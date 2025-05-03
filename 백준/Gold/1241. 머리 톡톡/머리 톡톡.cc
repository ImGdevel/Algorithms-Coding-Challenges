#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <math.h>

using namespace std;


vector<int> getDivisors(int n) {
	vector<int> divisors;

	for (int i = 1; i <= sqrt(n); ++i) {
		if (n % i == 0) {
			divisors.push_back(i);
			if (i != n / i) {
				divisors.push_back(n / i);
			}
		}
	}

	return divisors;
}

int main() {
	int N;
	cin >> N;

	vector<int> head(N);
	unordered_map<int, int> map, answer;

	for (int i = 0, n; i < N; i++) {
		cin >> n;
		head[i] = n;
		map[n]++;
	}

	for (auto& h : head) {

		if (answer.find(h) == answer.end()) {
			int sum = 0;
			vector<int> div = getDivisors(h);

			for (int d : div) {
				if (map.find(d) != map.end()) {
					sum += map[d];
				}
			}
			
			answer[h] = sum - 1;
		}

		cout << answer[h] << "\n";
	}
}