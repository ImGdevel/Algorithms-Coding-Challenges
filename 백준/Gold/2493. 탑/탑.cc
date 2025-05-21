#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
	int N;
	cin >> N;

	vector<int> arr(N + 1);
	for (int i = 1; i <= N; i++) {
		cin >> arr[i];
	}

	vector<int> dp(N + 1);
	dp[0] = 0; dp[1] = 0;
	for (int i = 2; i <= N; i++) {
		int num = arr[i];
		
		int index = i - 1;
		// 현재 숫자가?
		while (index > 0)
		{
			if (arr[index] >= num) {
				dp[i] = index;
				break;
			}
			index = dp[index];
		}
	}

	for (int i = 1; i <= N; i++) {
		cout << dp[i] << " ";
	}
}