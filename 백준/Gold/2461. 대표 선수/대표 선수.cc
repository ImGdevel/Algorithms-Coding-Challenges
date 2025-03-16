//https://www.acmicpc.net/problem/3273
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define MAX 1000000

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N, M;
    cin >> N >> M;
    vector<vector<int>> arr(N, vector<int>(M));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> arr[i][j];
        }
    }

    int high_num = 0, high_class = 0, low_num, low_class;
    for (int i = 0; i < N; i++) {
        sort(arr[i].begin(), arr[i].end());
        if (high_num < arr[i][0]) {
            high_num = arr[i][0];
            high_class = i;
        }
    }

    vector<int> pos(N, 0);
    int min_gap = high_num;

    while (true)
    {
        low_num = high_num;
        low_class = 0;
        for (int i = 0; i < N; i++) {
            while (pos[i] + 1 < M && arr[i][pos[i] + 1] < high_num){
                pos[i]++;
            }
            int num = arr[i][pos[i]];
            if (num < low_num) {
                low_num = num;
                low_class = i;
            }
        }

        min_gap = min(min_gap, high_num - low_num);
        if (pos[low_class] + 1 < M) {
            high_num = arr[low_class][++pos[low_class]];
        }
        else {
            break;
        }
        
    }

    cout << min_gap;

    return 0;
}
