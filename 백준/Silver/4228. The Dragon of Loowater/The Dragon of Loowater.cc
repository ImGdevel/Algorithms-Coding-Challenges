#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


void solv(int N, int M) {

	vector<int> head(N), knight(M);

	for (int i = 0; i < N; i++) {
		cin >> head[i];
	}
	for (int i = 0; i < M; i++) {
		cin >> knight[i];
	}

	if (N > M) {
		cout << "Loowater is doomed!\n";
		return;
	}

	sort(head.begin(), head.end());
	sort(knight.begin(), knight.end());

	int gold = 0;
	int knight_point = 0;
	int min = M - N;
	for (int hp = 0; hp < N; hp++) {

		int h = head[hp];

		while (knight_point < M && !(h <= knight[knight_point]))
		{
			knight_point++;
		}

		// 머리수가 기사 수보다 많다면?
		if (knight_point - hp > min) {
			cout << "Loowater is doomed!\n";
			return;
		}

		// 기사 채용
		gold += knight[knight_point];
		knight_point++;
	}
	cout << gold << "\n";
}



int main() {

	while (true)
	{
		int N, M;
		cin >> N >> M;
		if (N == 0 && M == 0) {
			break;
		}
		solv(N, M);
	}
}


