#include<iostream>
#include<vector>
#include<math.h>

using namespace std;

bool isPrimay(int n) {
	if (n == 1 || n == 0) return false;
	if (n == 2 || n == 3) return true;
	if (n % 2 == 0 || n % 3 == 0) return false;

	int limit = (int)sqrt(n);
	for (int i = 5; i <= limit; i += 6) {
		if (n % i == 0 || n % (i + 2) == 0) return false;
	}
	return true;
}

void BF(int N, int count, int num) {
	if (N == count) {
		cout << num << "\n";
		return;
	}
	for (int i = 0; i <= 9; i++) {
		int n = num * 10 + i;
		if (isPrimay(n)) {
			BF(N, count + 1, n);
		}
	}
}

int main()
{
	int N;
	cin >> N;
	BF(N, 0, 0);
}