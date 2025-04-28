#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    int A, B;
    cin >> A >> B;

    queue<int> q;
    q.push(A);

    int count = 0;
    while (!q.empty())
    {
        count++;
        int size = q.size();

        for (int i = 0; i < size; i++) {
            int n = q.front();
            q.pop();

            if (n == B) {
                cout << count;
                return 0;
            }

            if ((long long)n * 2 <= B) {
                q.push(n * 2);
            }

            if ((long long)n * 10 + 1 <= B) {
                q.push(n * 10 + 1);
            }
        }
    }
    cout << -1;
}
