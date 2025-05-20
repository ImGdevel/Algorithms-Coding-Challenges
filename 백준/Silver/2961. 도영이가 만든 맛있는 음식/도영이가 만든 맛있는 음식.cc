#include<iostream>
#include<cmath>
#include<algorithm>

#define MAX_LONG 1000000000001

using namespace std;

int N;
int arr[10][2];
long long answer = MAX_LONG;

void BF(int index ,long long a, long long b) {

	if (index == N) {
		if(b != 0) answer = min(answer, abs(a - b));
		return;
	}

	BF(index + 1, a, b);
	BF(index + 1, a * arr[index][0], b + arr[index][1]);
}


int main() {

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> arr[i][0] >> arr[i][1];
	}

	BF(0, 1, 0);

	cout << answer;
}