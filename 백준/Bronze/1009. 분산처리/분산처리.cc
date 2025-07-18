#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int T;
    cin >> T;
    while (T--) {
        int a, b;
        cin >> a >> b;

        if (a % 10 == 0) {
            cout << 10 << '\n';
            continue;
        }

        long sub = 1;
        for (int i = 0; i < b; i++) {
            sub = (sub * (a % 10)) % 10;
        }

        cout << sub << endl;
    }


}
