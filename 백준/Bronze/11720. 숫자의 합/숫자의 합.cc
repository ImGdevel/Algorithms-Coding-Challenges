#include<iostream>

using namespace std;

int main() {
	int N;
	cin >> N;

	int sum = 0;
	for (int i = 0; i < N; i++) {
		char ch;
		cin >> ch;
		sum += ch - '0';
	}
	cout << sum;
}