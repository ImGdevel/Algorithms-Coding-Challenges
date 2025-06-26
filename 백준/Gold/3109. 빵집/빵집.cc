#include<iostream>
#include<vector>

using namespace std;

#define VVC vector<vector<char>> 
#define VVB vector<vector<bool>>

bool findPipeRoot(const VVC& grap, VVB& visited, const int& R, const int& C, int r, int c) {
    
    visited[r][c] = true;
    if (c == C-1) {
        return true;
    }

    // 위쪽
    if (r > 0 && !visited[r - 1][c + 1]) {
        if (findPipeRoot(grap, visited, R, C, r - 1, c + 1)) {
            return true;
        }
    }

    // 가운데
    if (!visited[r][c + 1]) {
        if (findPipeRoot(grap, visited, R, C, r, c + 1)) {
            return true;
        }
    }

    // 아래쪽
    if (r < R-1 && !visited[r + 1][c + 1]) {
        if (findPipeRoot(grap, visited, R, C, r + 1, c + 1)) {
            return true;
        }
    }

    //visited[r][c] = false;

    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);

    int R, C;
    cin >> R >> C;

    VVC arr(R, vector<char>(C));
    VVB visited(R, vector<bool>(C, false));
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            char ch;
            cin >> ch;
            if (ch == 'x') {
                visited[i][j] = true;
            }
            arr[i][j] = ch;
        }
    }

    int answer = 0;
    for (int i = 0; i < R; i++) {
        if (!visited[i][0]) {
            if (findPipeRoot(arr, visited, R, C, i, 0)) {
                answer++;
            }
        }
    }

    cout << answer;
}