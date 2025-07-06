#include<iostream>
#include<vector>

using namespace std;


// 전개도를 생각해보자. 

// 1 


int dice[6]; 
int board[20][20];
int pointer[6];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);
    
    // 항상 dice의 포인트를 고정 시켜버린다면?
    // 1은 항상위 // 6은 항상 아래

    int N, M, start_x, start_y, K;
    cin >> N >> M >> start_x >> start_y >> K;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> board[i][j];
        }
    }

    // 0이면 주사위 -> 바닥
    // 0이 라니면 바닥 -> 주사위(0)
    // 동 서 북 남

    // 각 포인터 위치는?

    for (int i = 0; i < 6; i++) pointer[i] = i;

    pair<int, int> pos = { start_x, start_y };
    for (int k = 0; k < K; k++) {
        int command;
        cin >> command;

        int temp;
        switch (command) {
        case 1: // 동
            if (pos.second + 1 >= M) continue;
            pos = { pos.first, pos.second + 1 };
            temp = pointer[0];
            pointer[0] = pointer[3];
            pointer[3] = pointer[5];
            pointer[5] = pointer[2];
            pointer[2] = temp;
            break;
        case 2: // 서
            if (pos.second - 1 < 0) continue;
            pos = { pos.first, pos.second - 1 };
            temp = pointer[0];
            pointer[0] = pointer[2];
            pointer[2] = pointer[5];
            pointer[5] = pointer[3];
            pointer[3] = temp;
            break;
        case 4: // 북
            if (pos.first + 1 >= N) continue;
            pos = { pos.first + 1, pos.second};
            temp = pointer[0];
            pointer[0] = pointer[4];
            pointer[4] = pointer[5];
            pointer[5] = pointer[1];
            pointer[1] = temp;

            break;
        case 3: // 남
            if (pos.first - 1 < 0) continue;
            pos = { pos.first - 1, pos.second };
            temp = pointer[0];
            pointer[0] = pointer[1];
            pointer[1] = pointer[5];
            pointer[5] = pointer[4];
            pointer[4] = temp;
            break;
        default:
            break;
        }

        // 바닥면 판별
        if (board[pos.first][pos.second] != 0) {
            // 바닥 -> 주사위
            dice[pointer[5]] = board[pos.first][pos.second];
            board[pos.first][pos.second] = 0;
        }
        else {
            // 주사위 -> 바닥
            board[pos.first][pos.second] = dice[pointer[5]];
        }

        cout << dice[pointer[0]] << endl;
    }
}
