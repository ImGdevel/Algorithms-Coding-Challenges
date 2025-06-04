#include <iostream>
#include <queue>
#include <tuple>
#include <vector>

using namespace std;

int N, M, K;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
vector<vector<int>> map;
int visited[1001][1001][11]; // [y][x][벽 부순 횟수]

struct State {
    int y, x, breakCount;
};

int bfs() {
    queue<tuple<int, int, int>> q; // y, x, 벽 부순 횟수
    q.push({0, 0, 0});
    visited[0][0][0] = 1;

    while (!q.empty()) {
        auto [y, x, broken] = q.front(); q.pop();

        // 목적지 도달 시
        if (y == N - 1 && x == M - 1)
            return visited[y][x][broken];

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M)
                continue;

            // 벽 아닌 경우
            if (map[ny][nx] == 0 && visited[ny][nx][broken] == 0) {
                visited[ny][nx][broken] = visited[y][x][broken] + 1;
                q.push({ny, nx, broken});
            }

            // 벽인 경우 && 더 부술 수 있는 경우
            if (map[ny][nx] == 1 && broken < K && visited[ny][nx][broken + 1] == 0) {
                visited[ny][nx][broken + 1] = visited[y][x][broken] + 1;
                q.push({ny, nx, broken + 1});
            }
        }
    }

    return -1;
}

int main() {
    cin >> N >> M >> K;
    map.resize(N, vector<int>(M));

    for (int i = 0; i < N; i++) {
        string row;
        cin >> row;
        for (int j = 0; j < M; j++) {
            map[i][j] = row[j] - '0';
        }
    }

    cout << bfs() << "\n";
    return 0;
}
