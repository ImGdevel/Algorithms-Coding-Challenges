#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

#define VLL vector<pair<long,long>>


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);

    int N;
    cin >> N;
    vector<int> arr(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end(), greater<>());

    int sum = 0, zero_count = 0;
    int last_index = N;
    for (int i = 0; i < last_index && arr[i] > 0; ) {
        if (arr[i] > 1 && (i+1 < N && arr[i+1] > 1)) {
            // 묶는게 가능한 경우
            sum += arr[i] * arr[i + 1];
            i += 2;
        }
        else {
            sum += arr[i];
            i++;
        }
    }

    for (int i = N-1; i >= 0 && arr[i] <= 0;) {
        if (i - 1 >= 0 && arr[i - 1] <= 0) {
            // 묶는게 가능한 경우
            sum += arr[i] * arr[i - 1];
            i -= 2;
        }
        else {
            sum += arr[i];
            i--;
        }
    }

    cout << sum;
}
