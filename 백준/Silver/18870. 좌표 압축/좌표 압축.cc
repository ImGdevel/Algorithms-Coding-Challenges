#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

int main() {
	int N;
	cin >> N;

	vector<int> ori(N), arr(N);
	for (int i = 0, n; i < N; i++) {
		cin >> n;
		ori[i] = n;
		arr[i] = n;
	}
	sort(arr.begin(), arr.end());

	unordered_map<int, int> map;
	int count = 0;
	int prev = arr[0];
	map[prev] = 0;
	for (int i = 1; i < N; i++) {
		if (arr[i] > prev) {
			count++;
			map[arr[i]] = count;
			prev = arr[i];
		}
	}
	
	for (int i = 0; i < N; i++) {
		cout << map[ori[i]] << " ";
	}
}