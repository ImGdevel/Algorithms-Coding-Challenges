#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

#define INT_MAX 100000000

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);

    int N, L;
    cin >> N >> L;

    vector<pair<int, int>> arr(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[i].first >> arr[i].second;
    }

    sort(arr.begin(), arr.end());

    int point = -1;
    int answer = 0;
    for (int i = 0; i < N; i++) {
        // 현재 위치에서 다음 포인트까지 계산
        if (arr[i].second <= point) continue;
        point = max(arr[i].first, point);

        while (point < arr[i].second) {
            point += L;
            answer++;
        }
    }

    cout << answer;

}