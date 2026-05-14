#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    int n = arr1.size();
    int m = arr2[0].size();
    int k = arr2.size();

    vector<vector<int>> answer(n, vector<int>(m, 0));

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            for (int t = 0; t < k; t++) {
                answer[i][j] += arr1[i][t] * arr2[t][j];
            }
        }
    }

    return answer;
}