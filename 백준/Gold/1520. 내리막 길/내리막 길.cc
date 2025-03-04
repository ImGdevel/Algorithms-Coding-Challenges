//https://www.acmicpc.net/problem/1520
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int DFS(const vector<vector<int>>& arr , vector<vector<int>>& dp, int R, int C, int r, int c) {
    if (r == R-1 && c == C-1) {
        return 1;
    }

    if (dp[r][c] != -1) {
        return dp[r][c];
    }

    dp[r][c] = 0;
    int dr[4][2]{ {1, 0} ,{0,-1}, {0,1}, {-1,0} };
    for (int i = 0; i < 4; i++) {
        int nr = dr[i][0] + r;
        int nc = dr[i][1] + c;
        if (nr >= 0 && nc >= 0 && nr < R && nc < C && arr[r][c] > arr[nr][nc]) {
            dp[r][c] += DFS(arr, dp, R, C, nr, nc);
        }
    }

    return dp[r][c];
}



int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int R, C;
    cin >> R >> C;

    vector<vector<int>> arr(R, vector<int> (C)), dp(R, vector<int>(C, -1));
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> arr[i][j];
        }
    }

    cout << DFS(arr, dp, R, C, 0, 0);
    return 0;
}
