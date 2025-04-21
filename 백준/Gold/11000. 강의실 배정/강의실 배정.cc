#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main() {

	int N;
	cin >> N;
	vector<pair<int, int>> arr;

	for (int i = 0; i < N; i++) {
		int s, e;
		cin >> s >> e;

		arr.push_back({ s,e });
	}

	sort(arr.begin(), arr.end());

	priority_queue<int, vector<int>, greater<int>> pq;
	pq.push(0);
	for (int i = 0; i < N; i++) {
		int s = arr[i].first, e = arr[i].second;

		if (pq.top() <= s) {
			pq.pop();
		}
		pq.push(e);
	}
	cout << pq.size();
}