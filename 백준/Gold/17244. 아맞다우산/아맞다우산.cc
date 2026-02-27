#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

struct Node{
    int x, y, state, time;
};


int main(){
    cin.tie(nullptr);
    std::ios::sync_with_stdio(false);

    int N, M;
    cin >> M >> N;

    vector<vector<char>> box(N, vector<char>(M));

    pair<int, int> start, end;

    vector<pair<int, int>> d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    vector<vector<vector<bool>>> visited(N, vector<vector<bool>>(M, vector<bool>(32, false)));
    vector<pair<int, int>> point;
    

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> box[i][j];

            //cout << box[i][j] << " ";

            if(box[i][j] == 'S'){
                start = {i, j};
            }
            else if(box[i][j] == 'X'){
                point.push_back({i, j});
            }
            else if(box[i][j] == 'E'){
                end = {i, j};
            }
        }
        //cout << "\n";
    }

    

    queue<Node> q;
    q.push({start.first, start.second, 0, 0});
    visited[start.first][start.second][0] = true;

    vector<int> answer;
    
    while(!q.empty()){
        Node current = q.front();
        q.pop();

        //cout << "Current: (" << current.x << ", " << current.y << "), State: " << current.state << ", Time: " << current.time << "\n";

        if(current.x == end.first && current.y == end.second && current.state == (1 << point.size()) - 1){
            cout << current.time << "\n";
            return 0;
        }


        for(int i=0; i<4; i++){
            int next_x = current.x + d[i].first;
            int next_y = current.y + d[i].second;
            int next_state = current.state;
            int next_time = current.time + 1;

            if(next_x < 0 || next_x >= N || next_y < 0 || next_y >= M 
                || box[next_x][next_y] == '#' || visited[next_x][next_y][current.state]){
                continue;
            }

            // 만약 다음 위치가 포인트라면, 해당 포인트의 상태를 업데이트
            if(box[next_x][next_y] == 'X'){
                //cout << "Found point at: (" << next_x << ", " << next_y << ")\n";
                for(int j = 0; j < point.size(); j++){
                    if(point[j].first == next_x && point[j].second == next_y){
                        next_state |= (1 << j);
                        break;
                    }
                }
            }
            visited[next_x][next_y][next_state] = 1;
            q.push({next_x, next_y, next_state, next_time});
        }
    }

    //cout << (min_element(answer.begin(), answer.end()) == answer.end() ? -1 : *min_element(answer.begin(), answer.end())) << "\n";

    return 0;
}