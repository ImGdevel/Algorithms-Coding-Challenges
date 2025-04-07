#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define MAX 100000000

int main() {
	// 밸만 포드 X
	int N;
	cin >> N;

	vector<vector<int>> map(N, vector<int>(N));

	for (int i = 0; i < N; i++) {
		for (int j = 0, n; j < N; j++) {
			cin >> n;
			if (n == 1 && i != j) {
				map[i][j] = n;
			}
			else {
				map[i][j] = MAX;
			}
		}
	}

	for (int k = 0; k < N; k++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = min(map[i][j], map[i][k] + map[k][j]);
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] != MAX) {
				cout << "1 ";
			}
			else {
				cout << "0 ";
			}
			
		}
		cout << endl;
	}

}