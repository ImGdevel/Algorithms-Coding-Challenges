#include<iostream>
#include<vector>

using namespace std;

#define VV vector<vector<int>>

int arr[40][40];

VV rotate(VV pice, int rotate) {
    VV v;
    int r = pice.size();
    int c = pice[0].size();

    switch (rotate) {
    case 0:
        return pice;
    case 1:
        v.resize(c, vector<int>(r));

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                v[j][r - i - 1] = pice[i][j];
            }
        }

        break;
    case 2:
        v.resize(r, vector<int>(c));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                v[r - i - 1][c - j - 1] = pice[i][j];
            }
        }
        break;
    case 3:
        v.resize(c, vector<int>(r));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                v[c - j - 1][i] = pice[i][j];
            }
        }
        break;
    default:
        break;
    }

    return v;
}

void piceFit(VV pice, int R, int C) {

    // 조각 맞추기
    for (int i = 0; i < 4; i++) {

        // 돌린 조각
        VV p = rotate(pice ,i);
        int rr = p.size();
        int cc = p[0].size();

        for (int r = 0; r < R - rr + 1; r++) {
            for (int c = 0; c < C - cc + 1; c++) {
                bool isFit = true;
                
                for (int x = 0; x < rr && isFit; x++) {
                    for (int y = 0; y < cc && isFit; y++) {
                        if (p[x][y] == 1 && arr[r + x][c + y] == 1) {
                            isFit = false;
                            break;
                        }
                    }
                }

                if (isFit) {
                    for (int x = 0; x < rr; x++) {
                        for (int y = 0; y < cc; y++) {
                            if (p[x][y] == 1) {
                                arr[r + x][c + y] = 1;
                            }
                        }
                    }
                    return;
                }
            }
        }

    }



}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);
    
    int N, M, K;
    cin >> N >> M >> K;


    vector<VV> pice(K);

    for (int i = 0; i < K; i++) {
        int R, C;
        cin >> R >> C;

        VV p(R, vector<int>(C));

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                cin >> p[r][c];
            }
        }
        pice[i] = p;
    }

    for (VV p : pice) {
        piceFit(p, N, M);
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (arr[i][j]) {
                answer++;
            }
        }
    }
    cout << answer;
}
