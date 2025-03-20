#include<iostream>
#include<algorithm>
using namespace std;
#define MAX 1001

int N;
int best = 0;
int bestcost[MAX][3];
int color[MAX][3];
int notSame[3][2] = {{1,2},{0,2},{0,1}};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < 3; j++) {
            cin >> color[i][j];
            bestcost[i][j] = 0;
        }
    }
    bestcost[0][0] = color[0][0];
    bestcost[0][1] = color[0][1];
    bestcost[0][2] = color[0][2];

    for (int i = 1; i < N; i++) {
        for (int j = 0; j < 3; j++) {
            int selectLowColor = min(bestcost[i - 1][notSame[j][0]], bestcost[i - 1][notSame[j][1]]);            
            bestcost[i][j] = color[i][j] + selectLowColor;
        }
    }
    cout << min(min(bestcost[N-1][0], bestcost[N-1][1]), bestcost[N-1][2]);
}
