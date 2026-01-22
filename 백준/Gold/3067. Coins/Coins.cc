#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int T;
    cin >> T;

    while(T--){        
        int N;
        cin >> N;
        vector<int> coins(N+1);
        for(int i=1; i<= N; i++) {
            cin >> coins[i];
        }

        int K;
        cin >> K;

        vector<vector<int>> dp(N+1, vector<int>(K+1, 0));
        for(int i=0; i<=N; i++){
            dp[i][0] = 1;
        }

        
        for(int i=1; i<=N; i++){
            int c = coins[i];
            for(int k=0; k<=K; k++){
                if(k >= c)
                    dp[i][k] = dp[i][k-c] + dp[i-1][k];
                else
                    dp[i][k] = dp[i-1][k];
            }
        }


        cout << dp[N][K] << "\n";
    }
    return 0;
}