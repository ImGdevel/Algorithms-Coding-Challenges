#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> graph;
vector<bool> visited;
vector<int> value;

void DFS(int node, vector<vector<int>>& dp) {

	visited[node] = true;

	// 현재 노드를 포함 시킬것이냐 아니냐

	int result_X = 0, result_OX = 0;

	for (int next : graph[node]) {
		// 미방문 노드에 대해
		if (!visited[next]) {
			// 방문 시켜보기
			DFS(next, dp);
		}
		result_X += dp[next][0];
		result_OX += max(dp[next][0], dp[next][1]);
	}

	dp[node][0] = (result_OX);
	dp[node][1] = (result_X + value[node]);

	//cout << node + 1 << "=" << dp[node][0] << " " << dp[node][1] << endl;

}


int main() {

	int N;
	cin >> N;

	graph.resize(N);
	visited.resize(N, false);
	value.resize(N);
	vector<vector<int>> dp(N, vector<int>(2, 0));

	for (int i = 0; i < N; i++) {
		cin >> value[i];
	}

	for (int i = 0; i < N - 1; i++) {
		int a, b;
		cin >> a >> b;
		graph[a-1].push_back(b-1);
		graph[b-1].push_back(a-1);
	}

	DFS(0, dp);

	cout << max(dp[0][0], dp[0][1]);

}
