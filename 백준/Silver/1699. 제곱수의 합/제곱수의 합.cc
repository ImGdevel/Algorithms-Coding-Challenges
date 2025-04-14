#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define MAX_INT 1000000

int main() {

	int N;
	cin >> N;
	vector<int> pow ,dp(N+1, MAX_INT);
	
	int p = 1;
	while (true)
	{
		int n = p * p;
		if (N < n) {
			break;
		}
		pow.push_back(n);
		dp[n] = 1;
		p++;
	}

	dp[0] = 0;
	for (int i = 0; i < pow.size(); i++) {
		int x = pow[i];
		for (int k = x; k <= N; k++) {
			dp[k] = min(dp[k] , dp[k-x] + 1);
		}
	}

	cout << dp[N];
}
