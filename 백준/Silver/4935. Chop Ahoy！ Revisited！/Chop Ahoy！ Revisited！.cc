#include <iostream>
#include <vector>
#include <string>
using namespace std;

string s;
int n;
int countWays(int idx, int prevSum) {
    if (idx == n) return 1;

    int res = 0, currSum = 0;
    for (int i = idx; i < n; ++i) {
        currSum += s[i] - '0';
        if (currSum >= prevSum) {
            res += countWays(i + 1, currSum);
        }
    }
    return res;
}

int main() {
    int count = 1;
    while (cin >> s && s != "bye") {
        n = s.size();
        cout << count++ << ". " << countWays(0, 0) << "\n";
    }
    return 0;
}
