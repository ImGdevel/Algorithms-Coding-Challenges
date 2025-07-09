#include <iostream>
#include <vector>
#include<algorithm>
#include<queue>

using namespace std;

vector<int> num;
int N, M;

int answer[8];

void BF(int count, int prev_index) {
    if (M == count) {
        for(int i=0; i<M; i++){
            cout << answer[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = prev_index + 1; i < N; i++) {
        answer[count] = num[i];
        BF(count + 1, i);
    }
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> N >> M;

    for (int i = 0, n; i < N; i++) {
        cin >> n;
        num.push_back(n);
    }
    sort(num.begin(), num.end());

    BF(0, -1);
}
