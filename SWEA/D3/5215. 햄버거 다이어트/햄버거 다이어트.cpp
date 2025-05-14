#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void BF(const vector<int>& tas, const vector<int>& kal, int pos, int sum_tas, int sum_kal, int& answer, const int& L) {
	if (sum_kal > L) return;
	if (pos == tas.size()) {
		answer = max(answer, sum_tas);
		return;
	}
	// 선택 O
	BF(tas, kal, pos + 1, sum_tas + tas[pos], sum_kal + kal[pos], answer, L);
	// 선택 X
	BF(tas, kal, pos + 1, sum_tas, sum_kal, answer, L);
}

int solv() {
	int N, L;
	cin >> N >> L;
	vector<int> tas(N), kal(N);
	for (int i = 0; i < N; i++) {
		cin >> tas[i] >> kal[i];
	}
	int answer = 0;
	BF(tas, kal, 0, 0, 0, answer, L);
	return answer;
}

int main() {
	int T;
	cin >> T;
	for (int test_case = 1; test_case <= T; ++test_case) {
		cout << "#" << test_case << " " << solv() << "\n";
	}
	return 0;
}
