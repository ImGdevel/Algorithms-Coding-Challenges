#include <iostream>
#include <queue>
#include <vector>
#include <cmath>
using namespace std;

#define INF 1000000000

int N, M, K;
vector<vector<int>> graph;
vector<int> dist;
vector<bool> visited;

int main() {
	cin >> N >> M >> K;

	graph.resize(N);
	dist.resize(N, INF);
	visited.resize(N, false);

	for (int i = 0; i < M; i++) {
		int s, e;
		cin >> s >> e;
		graph[s - 1].push_back(e - 1);
	}

	queue<int> q;
	q.push(K - 1);
	visited[K - 1] = true;

	int layer = 0;
	while (!q.empty()) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int node = q.front();
			q.pop();
			dist[node] = layer;

			for (int next : graph[node]) {
				if (!visited[next]) {
					visited[next] = true;
					q.push(next);
				}
			}
		}
		layer++;
	}

	int best = -1;
	int best_node = -1;

	for (int i = 0; i < N; i++) {
		if (dist[i] != INF && i != K - 1) {
			int score = dist[i] + abs(K - (i + 1));
			if (score >= best && best_node < i + 1) {
				best_node = i + 1;
				best = score;
			}
		}
	}
	cout << best_node;
	return 0;
}
