#include <iostream>
#include <string>
#include <algorithm>
#include <unordered_set>
using namespace std;

int maxResult;

void dfs(string num, int cnt, int changeCount, unordered_set<string> visited[]) {
    if (cnt == changeCount) {
        maxResult = max(maxResult, stoi(num));
        return;
    }

    if (visited[cnt].find(num) != visited[cnt].end())
        return;

    visited[cnt].insert(num);

    for (int i = 0; i < num.size() - 1; ++i) {
        for (int j = i + 1; j < num.size(); ++j) {
            swap(num[i], num[j]);
            dfs(num, cnt + 1, changeCount, visited);
            swap(num[i], num[j]);
        }
    }
}

int main() {
    int T;
    cin >> T;
    for (int test_case = 1; test_case <= T; ++test_case) {
        string num;
        int changeCount;
        cin >> num >> changeCount;

        maxResult = 0;
        unordered_set<string> visited[11];

        dfs(num, 0, changeCount, visited);

        cout << "#" << test_case << " " << maxResult << "\n";
    }
    return 0;
}
