#include <iostream>
#include <list>
#include <vector>

using namespace std;

int main( ) {
	int N, K;
	cin >> N >> K;
	list<int> list;
	vector<int> answer;

	for (int i = 1; i <= N; i++) {
		list.push_back(i);
	}

	

	int index = 0;
	while (!list.empty()) 
	{
		auto it = list.begin();
		index = (index + K - 1) % list.size();

		advance(it, index);
		answer.push_back(*it);
		list.erase(it);
		
	}

	cout << "<" << answer[0];
	for (int i = 1; i < answer.size(); i++) {
		cout << ", " << answer[i];
	}
	cout << ">";

}
