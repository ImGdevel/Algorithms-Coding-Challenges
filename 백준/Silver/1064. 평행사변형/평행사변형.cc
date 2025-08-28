#include <bits/stdc++.h>
using namespace std;

struct Point {
    double x, y;
};

double dist(const Point& a, const Point& b) {
    return hypot(a.x - b.x, a.y - b.y);
}

bool collinear(const Point& a, const Point& b, const Point& c) {
    return fabs((b.x - a.x) * (c.y - a.y) -
                (b.y - a.y) * (c.x - a.x)) < 1e-9;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    Point A, B, C;
    cin >> A.x >> A.y >> B.x >> B.y >> C.x >> C.y;

    if (collinear(A, B, C)) {
        cout << -1 << "\n";
        return 0;
    }

    double AB = dist(A, B);
    double AC = dist(A, C);
    double BC = dist(B, C);

    vector<double> perimeters;
    perimeters.push_back(2 * (AB + AC)); // D1 = B+C-A
    perimeters.push_back(2 * (AB + BC)); // D2 = A+C-B
    perimeters.push_back(2 * (AC + BC)); // D3 = A+B-C

    double ans = *max_element(perimeters.begin(), perimeters.end())
               - *min_element(perimeters.begin(), perimeters.end());

    cout << fixed << setprecision(15) << ans << "\n";
    return 0;
}
