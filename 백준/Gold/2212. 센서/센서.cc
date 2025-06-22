#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);

    int N, K;
    cin >> N >> K;

    vector<int> arr(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    sort(arr.begin(), arr.end());

    vector<int> distance(N-1);

    for (int i = 0; i < N-1; i++) {
        distance[i] = arr[i + 1] - arr[i];
    }

    long answer = 0;
    sort(distance.begin(), distance.end());
    for (int i = 0; i < N - K; i++) {
        answer += distance[i];
    }

    cout << answer;
}