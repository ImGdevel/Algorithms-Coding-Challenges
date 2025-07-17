#include <iostream>
#include <vector>
using namespace std;

#define INT_MAX 1000000000

int main() {
	int N;
	cin >> N;

	vector<int> arr(N + 2), dp(N + 2, INT_MAX);

	for(int i = 1; i <= N; i++) {
		cin >> arr[i]; 
	}

	dp[0] = 0; 

	for(int i = 0; i <= N; i++) {
		int point = dp[i];
		for(int j = 1; j <= 3 && i + j <= N + 1; j++) {
			dp[i + j] = min(dp[i + j], arr[i + j] + point);
		}
	}

	cout << dp[N + 1];
	return 0;
}
