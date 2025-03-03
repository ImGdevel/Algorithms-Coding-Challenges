#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<pair<int, int>>> tree; // 그래프를 인접 리스트로 표현 (노드, 거리)
vector<bool> visited;
int max_distance = 0;
int farthest_node = 0;

// 첫 번째 DFS: 임의의 노드에서 가장 먼 노드 찾기
void firstDFS(int node, int distance) {
    visited[node] = true;
    if (distance > max_distance) {
        max_distance = distance;
        farthest_node = node;
    }
    for (auto neighbor : tree[node]) {
        int next_node = neighbor.first;
        int edge_weight = neighbor.second;
        if (!visited[next_node]) {
            firstDFS(next_node, distance + edge_weight);
        }
    }
}

// 두 번째 DFS: 가장 먼 노드에서 가장 먼 노드 찾기
void secondDFS(int node, int distance) {
    visited[node] = true;
    if (distance > max_distance) {
        max_distance = distance;
    }
    for (auto neighbor : tree[node]) {
        int next_node = neighbor.first;
        int edge_weight = neighbor.second;
        if (!visited[next_node]) {
            secondDFS(next_node, distance + edge_weight);
        }
    }
}

int main() {
    int V;
    cin >> V;
    tree.resize(V);
    visited.resize(V, false);

    // 간선 정보 입력
    for (int i = 0; i < V - 1; i++) {
        int u, v, w; // u와 v 사이에 가중치 w의 간선이 있다고 가정
        cin >> u >> v >> w;
        tree[u - 1].push_back({ v - 1, w }); // 0부터 시작하는 인덱스로 변환
        tree[v - 1].push_back({ u - 1, w });
    }

    // 첫 번째 DFS: 임의의 노드에서 가장 먼 노드 찾기
    firstDFS(0, 0);

    // 두 번째 DFS: 가장 먼 노드에서 가장 먼 노드 찾기
    visited.assign(V, false);
    max_distance = 0;
    secondDFS(farthest_node, 0);

    cout << max_distance << endl;

    return 0;
}
