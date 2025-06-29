#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);

    int N;
    cin >> N;

    vector<pair<int, int>> arr(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[i].first >> arr[i].second;
    }

    sort(arr.begin(), arr.end());

    // 1. 시작 
    // start 기록
    // pq 에 넣고
    // 다음 인덱스 찾기
    // pq top보다 작으면 pq에 넣고 반복

    // pq top보다 크다면 start와 pq top 과 차이를 기록한 뒤

    // 1. 시작으로 복귀

    priority_queue<int> pq;
    int index = 0;
    int start = 0;
    long long answer = 0;
    while (index < N) {
        start = arr[index].first;
        pq.push(arr[index].second);

        index++;
        while (index < N) {
            if (arr[index].first <= pq.top()) {
                pq.push(arr[index].second);
                index++;
                continue;
            }
            break;
        }
        int distance =  pq.top() - start;
        answer += distance;
    }
    cout << answer;
}
