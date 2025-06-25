#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>

using namespace std;

int dayOfMonth[12] = { 0,31,59,90,120,151,181,212,243,273,304,334 };
int prixSumMonth[12];

#define PP pair<pair<int,int>, pair<int,int>>

int DateToNum(int m, int d) {
    return dayOfMonth[m - 1] + d;
}


class Comp {
public:
    bool operator()(PP& a, PP& b) {
        int a_end = DateToNum(a.second.first, a.second.second);
        int b_end = DateToNum(b.second.first, b.second.second);
        return a_end < b_end; // 끝나는 날짜가 더 큰 꽃이 우선순위 높음 (max heap)
    }
};


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);

    int N;
    cin >> N;

    vector<PP> dir(N);
    vector<bool> used(N, false);

    for (int i = 0; i < N; i++) {
        cin >> dir[i].first.first >> dir[i].first.second
            >> dir[i].second.first >> dir[i].second.second;
    }


    int month = 3, days = 1;
    int count = 0;
    int target = DateToNum(12, 1);
    while (DateToNum(month, days) < target) {
        priority_queue<PP, vector<PP>, Comp> pq;

        for (int i = 0; i < N; i++) {
            if (DateToNum(dir[i].first.first, dir[i].first.second) <= DateToNum(month, days)
                && !used[i]) {
                used[i] = true;
                pq.push(dir[i]);
            }
        }

        if (pq.empty()) {
            cout << 0;
            return 0;
        }

        PP selected = pq.top();
        month = selected.second.first;
        days = selected.second.second;

        //cout << month << ":" << days << " " << DateToNum(month, days) << endl;

        count++;
    }

    cout << count;
}