class Solution {
    int solution(int[][] land) {
        int row = land.length;

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < 4; j++) {
                int maxPrev = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        maxPrev = Math.max(maxPrev, land[i - 1][k]);
                    }
                }
                land[i][j] += maxPrev;
            }
        }

        int answer = 0;
        for (int score : land[row - 1]) {
            answer = Math.max(answer, score);
        }

        return answer;
    }
}
