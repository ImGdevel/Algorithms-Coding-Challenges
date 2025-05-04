//계단
//https://www.acmicpc.net/problem/21600
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);
    
    int N;

    cin >> N;
    vector<int> v(N);
    vector<int> dp(N);


    int input;
    for (int i = 0; i < N; i++) {
        cin >> input;
        v[i] = input;
    }
    int result = 0;
    
    dp[0] = 1;
    for (int i = 1; i < N; i++) {
        dp[i] = min(v[i], dp[i - 1] + 1);
        result = max(result, dp[i]);
        //cout << dp[i] << " ";
    }

    cout << result << "\n";
}