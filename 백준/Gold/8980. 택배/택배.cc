#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

class Plan {
public:
	int s, e, w;
	Plan(int s, int e, int w): s(s), e(e), w(w) {}
};

class Campare {
public:
	bool operator()(const Plan& a, const Plan& b) {
		if (a.e == b.e) {
			return a.s < b.s;
		}
		return a.e > b.e;
	}
};


int main() {

	int N, C, M;
	cin >> N >> C >> M;

	priority_queue<Plan, vector<Plan>, Campare> pq;

	for (int i = 0; i < M; i++) {
		int s, e, w;
		cin >> s >> e >> w;
		pq.push(Plan(s-1, e-1, w));
	}
	
	vector<int> dp(N, 0);

	int answer = 0;
	while (!pq.empty())
	{
		Plan plan = pq.top();
		pq.pop();

		//cout << plan.s + 1 << "~" << plan.e + 1 << "=" << plan.w << endl;
		int max_value = 0;
		for (int i = plan.s + 1; i <= plan.e; i++) {
			max_value = max(dp[i], max_value);
		}

		int drop_box = min(C - max_value, plan.w);
		answer += drop_box;
		//cout << "add :" << drop_box << endl;
		for (int i = plan.s + 1; i <= plan.e; i++) {
			dp[i] += drop_box;
		}
	}
	
	cout << answer;
}
