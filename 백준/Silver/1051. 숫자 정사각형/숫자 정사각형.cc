#include <bits/stdc++.h>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    vector<string> grid(N);
    for(int i = 0; i < N; i++) {
        cin >> grid[i];
    }

    int maxSize = 1;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            for(int len = 1; i + len <= N && j + len <= M; len++) {
                char c = grid[i][j];
                if(grid[i][j + len - 1] == c && grid[i + len - 1][j] == c && grid[i + len - 1][j + len - 1] == c) {
                    maxSize = max(maxSize, len);
                }
            }
        }
    }

    cout << maxSize * maxSize << "\n";
    return 0;
}
