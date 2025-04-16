#include <iostream>
#include <vector>
#include <queue>
#include <list>
#include <algorithm>

using namespace std;

class Tree {
public:
	Tree(int a) {
		age = a;
	}
	int age;
	bool operator<(Tree& other) {
		return age > other.age;
	}
};

class Land {
public:
	int value;
	vector<Tree> trees;
	vector<Tree> dead;

	Land() : value(5) {}

	void addTree(int age) {
		trees.push_back(Tree(age));
	}

	void spring() {
		sort(trees.begin(), trees.end(), [](const Tree& a, const Tree& b) {
			return a.age < b.age;
		});

		vector<Tree> survived;
		for (Tree& tree : trees) {
			if (tree.age <= value) {
				value -= tree.age;
				tree.age += 1;
				survived.push_back(tree);
			}
			else {
				dead.push_back(tree);
			}
		}
		trees = move(survived);
	}

	void summer() {
		for (const Tree& tree : dead) {
			value += tree.age / 2;
		}
		dead.clear();
	}

	void fall(vector<vector<Land>>& land, int r, int c, int N) {
		static const int dr[8][2] = { {1,0}, {1,1}, {0,1}, {0,-1}, {-1,-1}, {-1,0}, {-1, 1}, {1,-1} };
		for (const Tree& tree : trees) {
			if (tree.age % 5 == 0) {
				for (int i = 0; i < 8; ++i) {
					int nr = r + dr[i][0];
					int nc = c + dr[i][1];
					if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
						land[nr][nc].addTree(1);
					}
				}
			}
		}
	}

	void winter(int v) {
		value += v;
	}

	int getTree() const {
		return trees.size();
	}
};


void techTree(vector<vector<Land>>& land, const vector<vector<int>>& value, int N) {
	for (int y = 0; y < 4; y++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 재태크 시작!
				switch (y)
				{
				case 0:
					land[i][j].spring(); break;
				case 1:
					land[i][j].summer(); break;
				case 2:
					land[i][j].fall(land, i, j, N); break;
				case 3:
					land[i][j].winter(value[i][j]); break;
				default:
					break;
				}
			}
		}
	}
}

int main() {
	int N, M, K;
	cin >> N >> M >> K;
	vector<vector<int>> value(N, vector<int>(N));
	vector<vector<Land>> land(N, vector<Land>(N));

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> value[i][j];
		}
	}
	for (int i = 0; i < M; i++) {
		int x, y, z;
		cin >> x >> y >> z;
		land[x-1][y-1].addTree(z);
	}

	for (int k = 0; k < K; k++) {
		techTree(land, value, N);
	}

	int answer = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			answer += land[i][j].getTree();
		}
	}
	cout << answer;

}
