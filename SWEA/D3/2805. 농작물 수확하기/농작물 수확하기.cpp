#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

int arr[50][50];

int solv() {
    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            char c;
            cin >> c;
            arr[i][j] = c - '0';
        }
    }

    int haf = N / 2;
    int answer = 0;
    for (int i = 0; i < N; i++) {
        int n = abs(haf - i);
        for (int j = n; j < N - n; j++) {
            answer += arr[i][j];
        }
    }
    return answer;
}


int main() {
    int T;
    cin >> T;
    for (int i = 1; i <= T; i++) {
        cout << "#" << i << " " << solv() << "\n";
    }

    return 0;
}
