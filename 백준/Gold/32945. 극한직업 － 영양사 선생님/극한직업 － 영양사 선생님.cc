#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

class Student {
public:
	int start = 0;
	int end = 0;

	Student() {};

	Student(int s, int e) {
		start = s; end = e;
	}

	bool check(int t) {
		return (start <= t && end > t);
	}

};


int main() {
	int N;
	cin >> N;
	vector<long> arr(N);

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	sort(arr.begin(), arr.end());

	vector<Student> st(N);

	vector<int> dp(N + 1, 0);

	for (int i = 0; i < N; i++) {
		int start = N - i - 1;
		int end = N - i + arr[i] - 1;
		dp[i] += 1;
		dp[min(end, N)] -= 1;
	}

	int sum = 0;
	int best = 0;
	for (int i = 0; i < N; i++) {
		sum += dp[i];
		best = max(best, sum);
	}
	cout << best;
}


