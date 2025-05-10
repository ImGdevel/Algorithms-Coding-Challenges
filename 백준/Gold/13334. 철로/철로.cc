#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct Interval {
    int start, end;
    Interval(int h, int o) {
        start = min(h, o);
        end = max(h, o);
    }
    bool operator<(const Interval& other) const {
        return end < other.end; // 끝나는 위치 기준 오름차순 정렬
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n;
    cin >> n;
    vector<Interval> list;
    for (int i = 0; i < n; ++i) {
        int h, o;
        cin >> h >> o;
        list.emplace_back(h, o);
    }

    int d;
    cin >> d;

    sort(list.begin(), list.end());

    priority_queue<int, vector<int>, greater<int>> pq; // 시작 위치를 저장하는 최소 힙
    int answer = 0;

    for (const auto& interval : list) {
        int start = interval.start;
        int end = interval.end;

        // 현재 [end - d, end] 구간 안에 start가 포함되지 않는 구간 제거
        while (!pq.empty() && pq.top() < end - d) {
            pq.pop();
        }

        // 현재 사람 추가
        if (end - start <= d) {
            pq.push(start);
        }

        answer = max(answer, (int)pq.size());
    }

    cout << answer << '\n';
    return 0;
}
