#include<iostream>
#include<string>
#include<algorithm>

using namespace std;


int solv() {
	string str;
	cin >> str;
	int MAX_LEN =  str.size();

	int len = min(MAX_LEN / 2, 10);
	for (int i = 1; i <= len; i++) {
		string pice = str.substr(0, i);
		//cout << str.substr(0, i) << " " << str.substr(i + 1, i) << "\n";
		if (str.substr(0, i) == str.substr(i, i)) {
			return i;
		}
	}
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