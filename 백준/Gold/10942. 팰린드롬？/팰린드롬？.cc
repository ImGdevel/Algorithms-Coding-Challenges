//https://www.acmicpc.net/problem/10942
#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N, T;
    cin >> N;
    vector<int> arr(N);
    vector<vector<bool>> dp(N, vector<bool> (N, false));
    
    for (int i = 0; i < N; i++) {
        cin >> arr[i];

        dp[i][i] = true;
    }

    for (int s = N - 2; s >= 0; s--) {

        dp[s][s + 1] = (arr[s] == arr[s + 1]);
        for (int e = s + 2; e < N; e++) {
            if (arr[s] == arr[e]) {
                dp[s][e] = dp[s + 1][e - 1];
            }
        }
    }

    cin >> T;
    while (T--)
    {
        int a, b;
        cin >> a >> b;

        cout << dp[a - 1][b - 1] << "\n";
    }
}
