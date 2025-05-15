#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>


using namespace std;

int L = 7;
int arr[4][4];
unordered_set<string> set[4][4];
unordered_set<int> answer;
int dr[4][2] = { {-1,0}, { 0,-1 }, { 1, 0 }, { 0,1 } };

void BF(int r, int c, string str) {

    str += to_string(arr[r][c]);
    if (set[r][c].find(str) != set[r][c].end()) {
        return;
    }

    if (str.size() == L) {
        answer.insert(stoi(str));
        //cout << stoi(str) << endl;
        return;
    }
    set[r][c].insert(str);
    
    if (r + 1 < 4) {
        BF(r + 1, c, str);
    }
    if (r - 1 >= 0) {
        BF(r - 1, c, str);
    }
    if (c + 1 < 4) {
        BF(r, c + 1, str);
    }
    if (c - 1 >= 0) {
        BF(r, c - 1, str);
    }
}


int solv() {
    answer.clear();
    
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            cin >> arr[i][j];
            set[i][j].clear();
        }
    }
    

    // 현재 위치에서 출발
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            BF(i, j, "");
        }
    }

    return answer.size();
}


int main() {
    int T = 10;
    cin >> T;
    for (int i = 1; i <= T; i++) {
        cout << "#" << i << " " << solv() << "\n";
    }

    return 0;
}
