#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<unordered_map>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);

    int N, M, K;
    cin >> N >> M >> K;

    vector<int> arr(K), distance;
    for (int i = 0; i < K; i++) {
        cin >> arr[i];
    }
    vector<bool> visited(K, 0);

    for (int i = 0; i < K - 1; i++) {
        for (int j = i + 1; j < K; j++) {
            distance.push_back(arr[j] - arr[i]);
        }
    }

    sort(distance.begin(), distance.end());

    int left = 0, right = distance.size() - 1;
    int point = 0;
    while (left <= right) {
        int mid = (left + right) / 2;
        int target = distance[mid];

        // 확인
        int sum = 0, count = 1;
        for (int i = 1; i < K && count < M; i++) {
            sum += arr[i] - arr[i - 1];
            if (sum >= target) {
                count++;
                sum = 0;
            }
        }

        if (count >= M) {
            left = mid + 1;
            point = target;
        }
        else {
            right = mid - 1;
        }
    }

    int sum = 0, count = 1;
    cout << "1";
    for (int i = 1; i < K; i++) {
        sum += arr[i] - arr[i - 1];
        if (sum >= point && count < M) {
            cout << "1";
            sum = 0;
            count++;
        }
        else {
            cout << "0";
        }

    }

}