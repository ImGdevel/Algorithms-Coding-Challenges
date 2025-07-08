#include <iostream>
#include <vector>
#include<algorithm>
#include<queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N;
    cin >> N;
    vector<int> arr(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[N - i - 1];
    }

    int max_num = arr[0];
    int answer = 0;
    for (int i = 1; i < N; i++) {
        if (max_num <= arr[i]) {
            int newNum = max_num - 1;
            answer += (arr[i] - newNum);
            arr[i] = newNum;
        }
        max_num = arr[i];
    }

    cout << answer;
}
