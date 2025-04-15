#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int N;
	cin >> N;
	vector<int> dp;

	for (int i = 0, n; i < N; i++) {
		cin >> n;
		auto it = lower_bound(dp.begin(), dp.end(), n);
		if (it == dp.end()) {
			dp.push_back(n);
		}
		else {
			*it = n;
		}
	}

	cout << N - dp.size();
}
