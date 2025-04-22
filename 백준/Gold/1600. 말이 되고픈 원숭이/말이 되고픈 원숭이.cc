#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

class Node {
public:
	int r;
	int c;
	int count;
	int coin;

	Node(int r, int c, int count, int coin) : r(r), c(c), count(count), coin(coin) {}
};

int BFS(const vector<vector<int>>& arr, int R, int C, int K) {
	
	int monkey[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };
	int horse[8][2] = { {2,1},{-2,1},{1,2},{1,-2}, {2,-1}, {-2,-1},{-1, 2}, {-1,-2} };


	vector<vector<vector<bool>>> check(R, vector<vector<bool>>(C, vector<bool>(K + 1, false)));


	queue<Node> q;
	q.push(Node(0, 0, 0, 0));
	check[0][0][0] = true;

	while (!q.empty())
	{
		Node node = q.front();
		q.pop();

		if (node.r == R-1 && node.c == C-1) {
			return node.count;
		}

		// 코인이 남아있다면?
		if (node.coin < K) {
			for (int i = 0; i < 8; i++) {
				int nr = horse[i][0] + node.r;
				int nc = horse[i][1] + node.c;
				// 말처럼 처럼
				if (nr >= 0 && nc >= 0 && nr < R && nc < C
					&& !check[nr][nc][node.coin + 1] && arr[nr][nc] == 0) {
					q.push(Node(nr, nc, node.count + 1, node.coin + 1));
					check[nr][nc][node.coin + 1] = true;
				}
			}
		}
		

		for (int i = 0; i < 4; i++) {
			int nr = monkey[i][0] + node.r;
			int nc = monkey[i][1] + node.c;
			// 원숭이 처럼

			// 만약 다음 지역이 방문노드지만 내가 아직 코인이 있다면? 
			if (nr >= 0 && nc >= 0 && nr < R && nc < C
				&& !check[nr][nc][node.coin] && arr[nr][nc] == 0) {
				q.push(Node(nr, nc, node.count + 1, node.coin));
				check[nr][nc][node.coin] = true;
			}
		}
	}

	return -1;
}

int main( ) {
	int K, R, C;

	cin >> K >> C >> R;

	vector<vector<int>> arr(R, vector<int>(C));

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> arr[i][j];
		}
	}

	cout << BFS(arr, R, C, K);

}
