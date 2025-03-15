#include <iostream>
#include <queue>
#include <utility>
#include <set>

using namespace std;

void Solution() {
    multiset<int> bagSet;
    priority_queue<pair<int, int>> pq;
    int N, K;
    cin >> N >> K;
    

    for (int i = 0, w, v; i < N; i++) {
        cin >> w >> v;
        pq.push({ v,w });
    }

    for (int i = 0, b; i < K; i++) {
        cin >> b;
        bagSet.insert(b);
    }

    long long maxValue = 0;

    while (!pq.empty())
    {
        pair<int, int> ob = pq.top();
        pq.pop();

        auto it = bagSet.lower_bound(ob.second);

        if (it != bagSet.end()) {
            maxValue += ob.first;
            bagSet.erase(it);
        }
    }

    cout << maxValue;
}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    Solution();
    return 0;
}
