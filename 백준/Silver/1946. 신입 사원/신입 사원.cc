#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);
    
    int T;
    cin >> T;

    while (T--) {

        int N;
        cin >> N;
        vector<pair<int,int>> arr(N);

        for (int i = 0; i < N; i++) {
            cin >> arr[i].first >> arr[i].second;
        }

        sort(arr.begin(), arr.end());

        int best_second = arr[0].second;
        int answer = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i].second < best_second) {
                answer++;
                best_second = arr[i].second;
            }
        }
        cout << answer << "\n";
    }
}