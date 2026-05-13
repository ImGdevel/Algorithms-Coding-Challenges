#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

struct Task {
    int no, req_t, task_t;

    bool operator<(const Task& n) const {
        if (task_t == n.task_t) {
            return no > n.no;
        }
        return task_t > n.task_t;
    }
};

bool comp(const vector<int>& v1, const vector<int>& v2) {
    return v1[0] < v2[0];
}

int solution(vector<vector<int>> jobs) {
    int answer = 0;

    sort(jobs.begin(), jobs.end(), comp);

    priority_queue<Task> pq;

    int N = jobs.size();
    int time = 0;
    int idx = 0;
    int done = 0;

    while (done < N) {
        // 현재 시간까지 요청된 작업들을 모두 pq에 넣음
        while (idx < N && jobs[idx][0] <= time) {
            pq.push({idx, jobs[idx][0], jobs[idx][1]});
            idx++;
        }

        // 처리할 수 있는 작업이 없으면 다음 작업 요청 시간으로 점프
        if (pq.empty()) {
            time = jobs[idx][0];
            continue;
        }

        // 대기 중인 작업 중 작업 시간이 가장 짧은 작업 수행
        Task cur = pq.top();
        pq.pop();

        time += cur.task_t;

        // 요청 시간부터 종료 시간까지 걸린 시간 누적
        answer += time - cur.req_t;

        done++;
    }

    return answer / N;
}