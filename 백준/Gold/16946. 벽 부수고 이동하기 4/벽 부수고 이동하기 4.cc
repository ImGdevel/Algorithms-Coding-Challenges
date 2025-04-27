#include <iostream>
#include <vector>
#include <queue>
#include <unordered_set>

using namespace std;

int BFS(
	const vector<vector<char>>& arr, 
	vector<vector<bool>>& check, 
	vector<vector<int>>& area, 
	vector<int>& dp, 
	int index, 
	pair<int, int> start, 
	int R, int C
) {
	int dr[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };
	
	vector<pair<int, int>> stack;
	queue<pair<int, int>> q;
	int answer = 1;

	q.push(start);
	check[start.first][start.second] = true;
	stack.push_back(start);

	while (!q.empty())
	{
		pair<int, int> node = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nr = node.first + dr[i][0];
			int nc = node.second + dr[i][1];

			if (nr < R && nc < C && nr >= 0 && nc >= 0
				&& !check[nr][nc] && arr[nr][nc] == '0') {
				q.push({ nr,nc });
				check[nr][nc] = true;
				answer++;
				stack.push_back({ nr,nc });
			}
		}
	}

	dp.push_back(answer);

	for (pair<int, int> s : stack) {
		area[s.first][s.second] = index;
	}

	return answer;
}


int main() {
	int R, C;
	cin >> R >> C;

	vector<vector<char>> arr(R, vector<char>(C));
	vector<vector<int>> area(R, vector<int>(C));
	vector<vector<bool>> check(R, vector<bool>(C));
	vector<int> dp;
	dp.push_back(0);

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> arr[i][j];
		}
	}

	int index = 1;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (arr[i][j] == '0' && area[i][j] == 0) {
				BFS(arr, check, area, dp, index, { i,j }, R, C);
				index++;
			}
		}
	}

	int dr[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			int n = 0;
			unordered_set<int> set;
			if (arr[i][j] == '1') {
				n += 1;
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k][0];
					int nc = j + dr[k][1];
					if (nr < R && nc < C && nr >= 0 && nc >= 0
						&& arr[nr][nc] == '0') {

						int a = area[nr][nc];

						if (set.find(a) == set.end()) {
							n = (dp[a] + n) % 10;
							set.insert(a);
						}
					}
				}
				
			}
			cout << n;
		}
		cout << "\n";
	}
}
