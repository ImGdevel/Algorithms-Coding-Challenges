#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <unordered_set>
using namespace std;


void DFS(const vector<int>& arr, vector<int>& answer, unordered_set<string>& set, int index, int prev, const int& N, const int& M) {
	if (index == M) {
		// 출력
		string str;
		for (int n : answer) {
			str += (to_string(n) + " ");
		}
		if (set.find(str) == set.end()) {
			cout << str << "\n";
			set.insert(str);
		}
		return;
	}

	for (int i = prev; i < N; i++) {
		answer[index] = arr[i];
		DFS(arr, answer,set, index + 1, i, N, M);
	}
}

int main() {
	int N, M;
	cin >> N >> M;

	vector<int> arr(N), answer(M);
	unordered_set<string> set;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	sort(arr.begin(), arr.end());

	DFS(arr, answer, set, 0, 0, N, M);
}
