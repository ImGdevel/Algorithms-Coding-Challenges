#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>

using namespace std;

int main() {

	int N, K;
	cin >> N >> K;

	// N에서 K까지

	int maxRange = max(N, K) + 2;

	vector<int> pass(maxRange + 1);
	vector<bool> check(maxRange + 1, false);

	// BFS
	queue<int> queue;
	queue.push(N);
	check[N] = true;

	int count = 0;
	while (!queue.empty() && !check[K])
	{
		int size = queue.size();
		count++;
		for (int i = 0; i < size; i++) {
			int current = queue.front();
			queue.pop();

			int newNum = current + 1;
			if (newNum <= maxRange && !check[newNum]) {
				check[newNum] = true;
				pass[newNum] = current;
				queue.push(newNum);
			}

			newNum = current - 1;
			if (newNum >= 0 && !check[newNum]) {
				check[newNum] = true;
				pass[newNum] = current;
				queue.push(newNum);
			}

			newNum = current * 2;
			if (newNum <= maxRange && !check[newNum]) {
				check[newNum] = true;
				pass[newNum] = current;
				queue.push(newNum);
			}
		}

		
	}


	cout << count << endl;

	stack<int> s;
	int node = K;
	s.push(K);
	while (node != N)
	{
		int next = pass[node];
		s.push(next);
		node = next;
	}

	while(!s.empty()) {
		cout << s.top() << " ";
		s.pop();
	}

}
