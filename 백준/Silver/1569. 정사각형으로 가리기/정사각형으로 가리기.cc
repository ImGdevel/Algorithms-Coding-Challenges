#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    vector<pair<int,int>> points(N);
    for (int i = 0; i < N; i++) cin >> points[i].first >> points[i].second;

    int xmin = INT_MAX, xmax = INT_MIN, ymin = INT_MAX, ymax = INT_MIN;
    for (auto [x,y] : points) {
        xmin = min(xmin, x);
        xmax = max(xmax, x);
        ymin = min(ymin, y);
        ymax = max(ymax, y);
    }

    int L = max(xmax - xmin, ymax - ymin);

    // 후보 4가지: (xmin,ymin), (xmin,ymax-L), (xmax-L,ymin), (xmax-L,ymax-L)
    vector<pair<int,int>> candidates = {
        {xmin, ymin},
        {xmin, ymax - L},
        {xmax - L, ymin},
        {xmax - L, ymax - L}
    };

    auto check = [&](int sx, int sy) {
        int ex = sx + L, ey = sy + L;
        for (auto [x,y] : points) {
            if (!((x == sx || x == ex) && (sy <= y && y <= ey)) &&
                !((y == sy || y == ey) && (sx <= x && x <= ex))) {
                return false;
            }
        }
        return true;
    };

    for (auto [sx, sy] : candidates) {
        if (check(sx, sy)) {
            cout << L << "\n";
            return 0;
        }
    }

    cout << -1 << "\n";
    return 0;
}
