#include<iostream>
#include<vector>

using namespace std;

int board[9][9];

int solv() {


	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cin >> board[i][j];
		}
	}

	vector<bool> check;
	for (int i = 0; i < 9; i++) {
		check.clear();
		check.resize(10, false);
		for (int j = 0; j < 9; j++) {
			if (check[board[i][j]]) {
				return 0;
			}
			check[board[i][j]] = true;
		}
	}
	for (int i = 0; i < 9; i++) {
		check.clear();
		check.resize(10, false);
		for (int j = 0; j < 9; j++) {
			if (check[board[j][i]]) {
				return 0;
			}
			check[board[j][i]] = true;
		}
	}
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			check.clear();
			check.resize(10, false);
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 3; y++) {
					if (check[board[i * 3 + x][j * 3 + y]]) {
						return 0;
					}
					check[board[i * 3 + x][j * 3 + y]] = true;
				}
			}
		}
	}

	return 1;
}

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		cout << "#" << test_case << " " << solv() << "\n";

	}
	return 0;
}