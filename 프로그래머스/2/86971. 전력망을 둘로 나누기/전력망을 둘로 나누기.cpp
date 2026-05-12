#include <string>
#include <vector>
#include <queue>
#include <iostream>

#define INT_MAX 100000000

using namespace std;

int solution(int N, vector<vector<int>> wires) {
    int answer = INT_MAX;
    
    int W = wires.size();
    // 그래프 생성
    vector<vector<int>> graph(N+1);
    
    for(int i=0; i<W; i++){
        int s = wires[i][0];
        int e = wires[i][1];
        graph[s].push_back(e);
        graph[e].push_back(s);
    }
    
    // 간선 리스트를 준비하고 bool로 준비
    vector<bool> wir_check(W, true);
    
    // 순회하면서 N-1 번 임시로 제거하는 간선 준비
    for(int i=0; i<W; i++){
        wir_check[i] = false;
        int s = wires[i][0];
        int e = wires[i][1];
        // N-1번 각각 전체 탐색 수행 (N)
    
        // 만약 전체 순회하지 않았다면 해당 체크된 개수를 세고 N과 count N - count로 세기
        // 그 절대값이 가장 작은 값으로 실행
        
        // < 전체 탐색 수행> 
        
        // 1번 부터 시작 -> 인접 노드 탐색. 종료될 떄까지 수행
        
        queue<int> q;
        vector<bool> visited(N + 1, false);
        q.push(1);
        visited[1] = true;
        int count_vis = 1;
        
        while(!q.empty()){
            int node = q.front();
            q.pop();
            for(int next : graph[node]){
                // 만약 제거된 간선 경로라면?
                if((node == s && next == e) || (node == e && next == s)){
                    continue;
                }
                // 아직 방문 안했으면
                if(!visited[next]){
                    q.push(next);
                    visited[next] = true;
                    count_vis++; // 방문 횟수 증가
                }
            }
        }
        //만약 전체 순회 했으면 제외
        if(count_vis == N){
            continue;
        }
        
        //cout << s << " " << e << " " << N - count_vis << "\n";
        
        answer = min(abs(N - count_vis - count_vis), answer);
    }
    
    if(answer == INT_MAX){
        return -1;
    }
    
    return answer;
}