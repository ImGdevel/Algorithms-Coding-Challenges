#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <list>

using namespace std;

const int R = 12, C = 6;

bool BFS(vector<vector<char>>& map, vector<vector<bool>>& check, pair<int,int> start) {

	int dr[4][2] = { {0,1}, {0,-1}, {1,0}, {-1,0} };
	queue<pair<int, int>> queue;
	
	list<pair<int, int>> visited;
	char sameChar = map[start.first][start.second];
	//cout << "find char :" << sameChar << endl;
	queue.push(start);
	check[start.first][start.second] = true;
	visited.push_back(start);

	while (!queue.empty())
	{
		pair<int,int> node = queue.front();
		queue.pop();

		for (int i = 0; i < 4; i++) {
			int nr = dr[i][0] + node.first;
			int nc = dr[i][1] + node.second;

			if (nr >= 0 && nc >= 0 && nr < R && nc < C 
				&& map[nr][nc] == sameChar && !check[nr][nc]) {
				queue.push({ nr,nc });
				check[nr][nc] = true;
				visited.push_back({ nr,nc });
			}
		}
	}

	if (visited.size() >= 4) {
		// 전부 제거
		for (pair<int, int> node : visited) {
			map[node.first][node.second] = '.';
		}
		return true;
	}
	return false;
}

void slideDown(vector<vector<char>>& map) {

	for (int c = 0; c < C; c++) {
		int floor = 0, r = 0;

		if (map[0][c] != '.') {
			for (; r < R; r++) {
				if (map[r][c] == '.') {
					floor = r;
					break;
				}
			}
		}
		for (; r < R; r++) {
			//찾다가 발견하면? 밑으로 내리기
			if (map[r][c] != '.') {
				map[floor][c] = map[r][c];
				map[r][c] = '.';
				floor++;
			}
		}
	}
}

bool game(vector<vector<char>>& map) {
	vector<vector<bool>> check(R, vector<bool>(C, false));
	bool boom = false;

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			// 삭제해야하는 뿌요를 찾는다.
			if (map[i][j] != '.' && BFS(map, check, { i,j })) {
				boom = true;
			}
		}
	}

	slideDown(map);

	/*
	for (int i = R - 1; i >= 0; i--) {
		for (int j = 0; j < C; j++) {
			cout << map[i][j] << " ";
		}
		cout << "\n";
	}
	*/
	
	return boom;
}

int main() {
	
	int answer = 0;
	vector<vector<char>> map(R, vector<char>(C));

	for (int i = R - 1; i >= 0; i--) {
		for (int j = 0; j < C; j++) {
			cin >> map[i][j];
		}
	}

	while (game(map)) {
		answer++;
	}

	cout << answer;
}
