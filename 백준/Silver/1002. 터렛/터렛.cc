#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int T;
    cin >> T;

    while (T--) {
        int x1, y1, r1, x2, y2, r2;
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

        // 중심 사이 거리
        double d = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));

        // 동일한 중심과 반지름
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            cout << -1 << '\n';
        }
        // 내접 or 외접
        else if (d == r1 + r2 || d == abs(r1 - r2)) {
            cout << 1 << '\n';
        }
        // 두 점에서 만남
        else if (abs(r1 - r2) < d && d < r1 + r2) {
            cout << 2 << '\n';
        }
        // 만나지 않음
        else {
            cout << 0 << '\n';
        }
    }

    return 0;
}
