#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
	int R, C;
	cin >> R >> C;

	vector<vector<char>> map(R, vector<char>(C));
	vector<vector<bool>> check(R, vector<bool>(C, false)), warter_check(R, vector<bool>(C, false));
	
	pair<int, int> start, end;

	queue<pair<int, int>> queue, warter;
	
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			char ch;
			cin >> ch;
			map[i][j] = ch;
			if (ch == 'S') {
				start = { i,j };
				queue.push({ i,j });
				check[i][j] = true;
			}
			else if (ch == 'D') {
				end = { i,j };
			}
			else if (ch == '*') {
				warter.push({ i,j });
				warter_check[i][j] = true;
			}
		}
	}


	int dr[4][2] = { {1,0}, {-1,0}, {0,1}, {0,-1} };
	// 물이 차오른다!
	bool is_arrived = false;
	int time = 0;
	while (!queue.empty())
	{
		time++;
		// 고슴 도치 이동!
		int sizeD = queue.size();
		for (int s = 0; s < sizeD; s++) {
			pair<int, int> d = queue.front();
			queue.pop();

			if (map[d.first][d.second] == '*') {
				continue;
			}


			for (int i = 0; i < 4; i++) {
				int nr = d.first + dr[i][0];
				int nc = d.second + dr[i][1];
				if (nr >= 0 && nc >= 0 && nr < R && nc < C 
					&& !warter_check[nr][nc] && (map[nr][nc] == '.' || map[nr][nc] == 'D') && !check[nr][nc])
				{
					if (map[nr][nc] == 'D') {
						cout << time;
						return 0;
					}
					
					check[nr][nc] = true;
					queue.push({ nr,nc });
				}
			}
		}

		// 물 이동!
		int sizeW = warter.size();
		for (int s = 0; s < sizeW; s++) {
			pair<int, int> w = warter.front();
			warter.pop();
			for (int i = 0; i < 4; i++) {
				int nr = w.first + dr[i][0];
				int nc = w.second + dr[i][1];
				if (nr >= 0 && nc >=0 && nr < R && nc < C 
					&& !warter_check[nr][nc] && map[nr][nc] == '.') 
				{
					warter_check[nr][nc] = true;
					map[nr][nc] = '*';
					warter.push({ nr,nc });
				}
			}
		}

	}



	cout << "KAKTUS";
}
