//퇴사2
//https://www.acmicpc.net/problem/15486
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N;
	cin >> N;
	
	vector<pair<int, int>>plan(N+1);
	vector<int>dp(N+1, 0);

	for (int i = 1; i <= N; i++) {
		int t, p;
		cin >> t >> p;
		plan[i] = { t,p };
	}

	for (int i = 1; i <= N; i++) {
		int time = plan[i].first - 1;
		int pay = plan[i].second;

		if (i + time <= N) {
			dp[i + time] = max(pay + dp[i-1] , dp[i + time]);
		}
		dp[i] = max(dp[i - 1], dp[i]);
	}

	cout << dp[N];
}

