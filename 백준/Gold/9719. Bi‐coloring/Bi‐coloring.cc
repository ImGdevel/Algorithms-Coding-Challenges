#include <iostream>
#include <vector>
#include <queue>
#include <math.h>

using namespace std;

bool coloring(const vector<vector<int>>& graph, vector<bool>& check, int start) {
	queue<int> q;
	vector<bool> color(check.size());
	q.push(start);
	check[start] = true;
	color[start] = true;
	
	while (!q.empty())
	{
		int n = q.front();
		bool current_color = color[n];
		q.pop();

		for (int next: graph[n]) {
			if (!check[next]) {
				q.push(next);
				check[next] = true;
				color[next] = !current_color;
			}
			else if(color[next] == current_color) {
				return false;
			}
		}
	}
	return true;
}

int solv() {
	int V, E;
	cin >> V >> E;

	vector<vector<int>> graph(V);

	for (int i = 0; i < E; i++) {
		int s, e;
		cin >> s >> e;
		
		graph[s].push_back(e);
		graph[e].push_back(s);
	}

	queue<int> q;
	vector<bool> check(V, false);
	int answer = 0;
	for(int i=0; i<V; i++){
		if (!check[i]) {
			if (!coloring(graph, check, i)) {
				// 컬러링 불가
				return -1;
			}
			answer++;
		}
	}

	return answer;
}



int main() {

	int T;
	cin >> T;

	while (T--)
	{
		int n = solv();
		if (n == -1) {
			cout << n << "\n";
		}
		else {
			cout << (1 << n) << "\n";
		}
	}
}


