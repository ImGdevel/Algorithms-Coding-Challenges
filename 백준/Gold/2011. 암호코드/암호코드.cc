#include<iostream>
#include<string>
#include<vector>

using namespace std;

#define MOD 1000000

int main(int argc, char** argv)
{
	string str;
	cin >> str;

	int N = str.length();
	vector<int> dp(N + 1);
    if (str[0] == '0') {
        cout << 0;
        return 0;
    }

    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= N; i++) {
        int idx = i - 1;
        if (str[idx] != '0') dp[i] = dp[i - 1];
        int twoDigit = (str[idx - 1] - '0') * 10 + (str[idx] - '0');
        if (twoDigit >= 10 && twoDigit <= 26)
            dp[i] = (dp[i] + dp[i - 2]) % MOD;
    }

	cout << dp[N];
}