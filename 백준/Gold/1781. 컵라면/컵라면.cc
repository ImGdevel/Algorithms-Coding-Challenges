#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<unordered_map>

using namespace std;

bool comp(pair<int, int>& a, pair<int, int>& b) {
    if (a.second == b.second) {
        return a.first < b.first;
    }
    return a.second > b.second;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);
    
    int N;
    cin >> N;

    vector<pair<int, int>> arr(N);

    for (int i = 0; i < N; i++) {
        int s, e; 
        cin >> s >> e;
        arr[i] = { s,e };
    }

    sort(arr.begin(), arr.end(), comp);
   
    vector<int> dp(N, 0);
    vector<int> zeroPoint(N);
    for (int i = 0; i < N; i++) {
        zeroPoint[i] = i;
    }

    for (auto n : arr) {
        int index = n.first - 1;
        while (dp[index] != 0) {
            index = zeroPoint[index];
            if (index < 0) break;
        }
        if (index < 0) continue;
        dp[index] = n.second;
        zeroPoint[n.first-1] = index - 1;
        zeroPoint[index] = index - 1;
    }

    int sum = 0;
    for (int n : dp) {
        sum += n;
    }
    cout << sum;
}

// 반례 
// 

