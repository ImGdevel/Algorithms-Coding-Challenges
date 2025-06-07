#include<iostream>
#include<deque>
#include<vector>
#include<algorithm>

using namespace std;

#define MAX_INT 100000000

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);
    
    int C, N;
    cin >> C >> N;
    vector<int> cost(N), value(N);
    int max_value = 0;
    for (int i = 0; i < N; i++) {
        cin >> cost[i] >> value[i];
        max_value = max(max_value, value[i]);
    }

    vector<int> dp(C + max_value + 1, MAX_INT);
    dp[0] = 0;
    for (int i = 1; i <= N; i++) {
        int v = value[i - 1];
        int c = cost[i - 1];
        for (int j = v; j <= C + max_value; j++) {
            dp[j] = min(dp[j], c + dp[j - v]);
        }
    }
    
    cout << *min_element(dp.begin() + C, dp.begin() + C + max_value + 1);
}