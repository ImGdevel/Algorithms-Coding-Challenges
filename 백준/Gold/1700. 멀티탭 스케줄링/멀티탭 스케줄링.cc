#include <iostream>
#include <vector>
#include <unordered_set>
#include <unordered_map>

using namespace std;

int main() {

	int N, K;
	cin >> N >> K;
	vector<int> task;
	unordered_set<int> multi;
	unordered_map<int, int> remind;

	for (int i = 0, n; i < K; i++) {
		cin >> n;
		task.push_back(n);
		remind[n]++;
	}

	// 일단 멀티탭 넣고
	int answer = 0;
	int index = 0;
	while (multi.size() < N) {
		int use = task[index];
		remind[use]--;
		if (remind[use] == 0) {
			remind.erase(use);
		}
		multi.insert(use);
		index++;
	}

	// 이제 시작
	for (; index < K; index++) {
		int next_use = task[index];
		
		// 미래시에서 일단 제거
		remind[next_use]--;
		if (remind[next_use] == 0) {
			remind.erase(next_use);
		}

		// 멀티텝이서 존재하지 않는다면?
		if (multi.find(next_use) == multi.end()) {
			
			// 뽑을 멀티탭 선정
			answer++;
			bool find = false;
			// 현재 멀티탭에서 가장 나중에 사용될 요소 제거
			for (auto& n : multi) {
				// 일단 이후 평생 안쓰이는건?
				if (remind.find(n) == remind.end()) {
					// 제거
					multi.erase(n);
					find = true;
					break;
				}
			}

			if (!find) {
				unordered_set<int> re(multi);
				// 만약 전부 미래에 사용되는거라면?
				// 가장 늦게 사용되는 것을 제거
				for (int x = index + 1; x < K && re.size() > 1; x++) {
					if (re.find(task[x]) != re.end()) {
						re.erase(task[x]);
					}
				}
				for (auto& n : re) {
					multi.erase(n);
				}
			}

			multi.insert(next_use);
		}

	}
	cout << answer;
}
