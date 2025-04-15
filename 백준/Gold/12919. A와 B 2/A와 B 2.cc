#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

bool DFS(string& str, const string& S) {
	if (str.size() == S.size()) {
		if (str == S) {
			return true;
		}
		return false;
	}

	if (str.back() == 'A') {
		str.pop_back();
		if (DFS(str, S)) {
			return true;
		}
		str.push_back('A');
	}
	if (str.front() == 'B') {
		reverse(str.begin(), str.end());
		str.pop_back();
		if (DFS(str, S)) {
			return true;
		}
		str.push_back('B');
		reverse(str.begin(), str.end());		
	}

	return false;
}


int main() {
	string S, T;
	cin >> S >> T;
	cout << DFS(T, S);
}
