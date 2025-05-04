#include <iostream>
#include <vector>
#include <queue>

using namespace std;



int main() {

	int K, N, M;

	cin >> K >> N >> M;

	vector<int> cow(K), count(N, 0);
	vector<vector<int>> graph(N);

	for (int i = 0, n; i < K; i++) {
		cin >> n;
		cow[i] = n - 1;
	}

	for (int i = 0, s, e; i < M; i++) {
		cin >> s >> e;
		graph[s - 1].push_back(e - 1);
	}

	for (int n : cow) {
		queue<int> q;
		vector<bool> visited(N, false);

		q.push(n);
		visited[n] = true;


		while (!q.empty())
		{
			int node = q.front();
			q.pop();
			count[node]++;
			for (int next : graph[node]) {
				// 다음 위치로
				if (!visited[next]) {
					q.push(next);
					visited[next] = true;
				}
			}
		}
	}

	int answer = 0;
	for (int n : count) {
		if (K == n) {
			answer++;
		}
	}
	cout << answer;

}


