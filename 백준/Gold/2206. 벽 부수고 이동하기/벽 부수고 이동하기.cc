#include<iostream>
#include<queue>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;
#define MAX 1000

int N, M;
int visited[MAX][MAX][2];

int BFS(vector<string> &graph){
    int d[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
    queue<pair<pair<int,int>,int>> q;
    q.push({{0,0},1});
    visited[0][0][1] = 1;

    while (!q.empty())
    {
        int r1 = q.front().first.first;
        int c1 = q.front().first.second;
        int wall = q.front().second;
        q.pop();
        
        if(r1 == N-1 && c1 == M-1){
            return visited[r1][c1][wall];
        }
        
        for(int i=0 ;i<4; i++){
            int r2 = r1 + d[i][0];
            int c2 = c1 + d[i][1];
            if(r2 >= 0 && c2 >= 0 && r2 < N && c2 < M){
                if(wall && graph[r2][c2] == '1'){ 
                    //벽을 부술수 있을때 벽수수고 다음칸으로 이동
                    q.push({{r2,c2},0});
                    visited[r2][c2][wall - 1] = visited[r1][c1][wall] + 1;
                }else if(graph[r2][c2] == '0' && visited[r2][c2][wall] == 0){
                    // 벽을 부수지 않고 이동
                    q.push({{r2,c2},wall});
                    visited[r2][c2][wall] = visited[r1][c1][wall] + 1;
                }
            }
        }
    }
    return -1;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);

    cin >> N >> M;
    vector<string> grape(N);
    for(short i=0; i<N; i++){
        cin >> grape[i];
    }
    cout << BFS(grape);

    return 0;
}