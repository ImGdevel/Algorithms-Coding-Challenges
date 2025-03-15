//https://www.acmicpc.net/problem/1167
#include <iostream>
#include <set>
#include <vector>
using namespace std;

#define pii pair<int,int>
#define graph vector<vector<pii>>


void DFS(const graph& g , vector<bool>& visited, vector<int>& weight, int node, int& best, int& best_node) {
	
	visited[node] = true;


	for (auto next : g[node]) {
		if (!visited[next.first]) {
			weight[next.first] = weight[node] + next.second;
			if (best < weight[next.first]) {
				best = weight[next.first];
				best_node = next.first;
			}
			DFS(g, visited, weight, next.first, best, best_node);
		}
	}
}

int main() {
	int V, i;
	cin >> V;
	graph g(V);
	i = V;
	while (i--)
	{
		int v, a, b;
		cin >> v;
		while (true)
		{
			cin >> a;
			if (a == -1) {
				break;
			}
			cin >> b;
			g[v-1].push_back({ a-1,b });
			g[a-1].push_back({ v-1,b });
		}
	}

	vector<bool> visted(V, false);
	vector<int> weight(V, 0);
	int best = 0;
	int best_node = 0;

	DFS( g , visted, weight, 0, best, best_node);

	visted.clear(); weight.clear();

	visted.resize(V, false);
	weight.resize(V, 0);
	best = 0;
	DFS(g, visted, weight, best_node, best, best_node);
	cout << best << endl;


}