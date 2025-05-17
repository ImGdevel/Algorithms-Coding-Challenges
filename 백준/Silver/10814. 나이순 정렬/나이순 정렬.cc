#include<iostream>
#include<map>
#include<vector>
#include<string>

using namespace std;

int main()
{
	int N;
	cin >> N;
	map<int, vector<string>> map;

	for (int i = 0; i < N; i++) {
		int n;
		string str;
		cin >> n >> str;
		map[n].push_back(str);
	}

	for (auto n : map) {
		for (string s : n.second) {
			cout << n.first << " " << s << "\n";
		}
	}
}