//https://www.acmicpc.net/problem/15652
#include <iostream>
using namespace std;

bool check[8];
int str[8];

void DFS(int N, int M, int prev ,int count) {

    if (count == M) {
        for (int i = 0; i < M; i++) {
            cout << str[i] + 1  << " ";
        }
        cout << '\n';
        return;
    }

    for (int i = prev; i < N; i++) {
        

        str[count] = i;
        DFS(N, M, i ,count + 1);

    }
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    DFS(N, M,0,0);

}