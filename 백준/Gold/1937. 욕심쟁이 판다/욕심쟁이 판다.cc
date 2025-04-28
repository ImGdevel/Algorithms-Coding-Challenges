#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int dr[4][2] = { {1,0}, {-1, 0}, {0,1}, {0,-1} };

int DFS(const vector<vector<int>>& map, vector<vector<int>>& dp, pair<int,int> pos , const int& N) {

	for (int i = 0; i < 4; i++) {
		int nr = dr[i][0] + pos.first;
		int nc = dr[i][1] + pos.second;
		
		if (nr >= 0 && nc >= 0 && nr < N && nc < N
			&& map[pos.first][pos.second] < map[nr][nc]){

			if (dp[nr][nc] == 0) {
				dp[pos.first][pos.second] = max(DFS(map, dp, { nr,nc }, N) + 1, dp[pos.first][pos.second]);
			}
			else if(dp[pos.first][pos.second] < dp[nr][nc] + 1){
				dp[pos.first][pos.second] = dp[nr][nc] + 1;
			}
		}
	}
	dp[pos.first][pos.second] = max(1, dp[pos.first][pos.second]);
	return dp[pos.first][pos.second];
}


int main() {

	int N;
	cin >> N;

	vector<vector<int>> map(N, vector<int>(N, 0)), dp(N, vector<int>(N, 0));

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}

	int answer = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (dp[i][j] == 0) {
				answer = max(DFS(map, dp, { i,j }, N), answer);
			}
		}
	}

	cout << answer;
}
