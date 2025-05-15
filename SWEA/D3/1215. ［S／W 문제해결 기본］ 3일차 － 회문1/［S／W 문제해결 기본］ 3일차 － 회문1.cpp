#include <iostream>
#include <vector>

using namespace std;

char arr[8][8];

int solv() {

    int K;
    cin >> K;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            char c;
            cin >> c;
            arr[i][j] = c;
        }
    }
    int count = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8 - K + 1; j++) {
            bool isPal = true;
            for (int x = 0; x < K / 2; x++) {
                //cout << arr[i][j + x] << " " << arr[i][(j + K - 1) - x] << endl;
                if (arr[i][j + x] != arr[i][(j + K - 1) - x]) {
                    isPal = false;
                    break;
                }
            }
            if (isPal) {
                count++;
            }
        }
    }


    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8 - K + 1; j++) {
            bool isPal = true;
            for (int x = 0; x < K / 2; x++) {
                //cout << arr[i][j + x] << " " << arr[i][(j + K - 1) - x] << endl;
                if (arr[j + x][i] != arr[(j + K - 1) - x][i]) {
                    isPal = false;
                    break;
                }
            }
            if (isPal) {
                //cout << "!";
                count++;
            }
        }
    }

    return count;
}


int main() {
    int T = 10;
    for (int i = 1; i <= T; i++) {
        cout << "#" << i << " " << solv() << "\n";
    }

    return 0;
}
