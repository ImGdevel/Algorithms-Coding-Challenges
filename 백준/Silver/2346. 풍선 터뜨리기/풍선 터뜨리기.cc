#include<iostream>
#include<list>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
	int N;
	cin >> N;

	list<pair<int, int>> rot;
	for (int i = 1, n; i <= N; i++) {
		
		cin >> n;
		rot.push_back({ i,n });
	}


	auto pos = rot.begin();
	vector<int> answer;
	while (rot.size() > 0)
	{
		pair<int, int> node = *pos;
		auto temp = pos;
		
		answer.push_back(node.first);
		cout << node.first << " ";

		if (node.second < 0) {

			if (pos == rot.begin()) {
				pos = rot.end();
			}
			pos--;
			rot.erase(temp);
			if (rot.size() == 0) break;

			for (int i = 0; i < -node.second - 1; i++) {
				if (pos == rot.begin()) {
					pos = rot.end();
				}
				pos--;
			}
		}
		else if (node.second > 0) {

			pos++;
			if (pos == rot.end()) {
				pos = rot.begin();
			}
			rot.erase(temp);
			if (rot.size() == 0) break;

			for (int i = 0; i < node.second - 1; i++) {
				pos++;
				if (pos == rot.end()) {
					pos = rot.begin();
				}
			}
		}
	}
}