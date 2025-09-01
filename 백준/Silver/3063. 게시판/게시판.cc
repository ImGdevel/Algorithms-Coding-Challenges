#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        int x1, y1, x2, y2;
        int x3, y3, x4, y4;
        cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3 >> x4 >> y4;

        int area1 = (x2 - x1) * (y2 - y1);

        int ix1 = max(x1, x3);
        int iy1 = max(y1, y3);
        int ix2 = min(x2, x4);
        int iy2 = min(y2, y4);

        int overlap = 0;
        if (ix1 < ix2 && iy1 < iy2) {
            overlap = (ix2 - ix1) * (iy2 - iy1);
        }

        int visible = area1 - overlap;
        cout << visible << "\n";
    }

    return 0;
}
