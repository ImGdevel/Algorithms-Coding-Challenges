#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    vector<int> marr, parr;


    for (int i = 0; i < N; i++) {
        int n;
        cin >> n;
        if (n < 0) {
            marr.push_back(n);
        }
        else {
            parr.push_back(n);
        }
    }

    sort(marr.begin(), marr.end());
    sort(parr.begin(), parr.end(), greater<>());

    int answer = 0;
    int midx = 0, pidx = 0;

    for (; midx < marr.size(); midx += M) {
        answer += (-marr[midx] * 2);
    }

    for (; pidx < parr.size(); pidx += M) {
        answer += (parr[pidx] * 2);
    }

    if (parr.size() == 0) {
        answer -= -marr[0];
    }
    else if (marr.size() == 0) {
        answer -= parr[0];
    }
    else if (parr[0] < -marr[0]) {
        answer -= -marr[0];
    }
    else if (parr[0] > -marr[0]) {
        answer -= parr[0];
    }

    cout << answer;
}
