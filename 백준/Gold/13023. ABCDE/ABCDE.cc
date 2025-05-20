#include<iostream>
#include<vector>

using namespace std;

void dfs(const vector<vector<int>>& map, vector<bool>& visited,int node ,int count, bool& find) {
	if (count >= 5) {
		find = true;
		return;
	}
	visited[node] = true;
	for (int next : map[node]) {
		if (!visited[next]) {
			dfs(map, visited, next, count + 1, find);
		}
	}
	visited[node] = false;
}

int main() {

	int N, V;
	cin >> N >> V;

	vector<vector<int>>map(N);
	for (int i = 0; i < V; i++) {
		int s, e;
		cin >> s >> e;
		map[s].push_back(e);
		map[e].push_back(s);
	}

	bool answer = false;
	vector<bool> visited(N, false);
	for (int i = 0; i < N && !answer; i++) {
		dfs(map, visited, i, 1, answer);
	}
	cout << answer;
}