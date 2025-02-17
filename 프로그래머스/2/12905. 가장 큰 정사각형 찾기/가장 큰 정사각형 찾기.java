class Solution
{
    public int solution(int [][]board)
    {
        int row = board.length;
        int col = board[0].length;
        int maxSize = Math.min(row, col);
        int[][] prefixSum = new int[row + 1][col + 1];
        // 누적합을 계산
        for(int i=1; i<=row; i++){
            for(int j=1; j<=col; j++){
                prefixSum[i][j] = board[i-1][j-1] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }
        
         
        for(int k = maxSize; k > 0; k--){
            int w = k * k;
            for(int i=k; i <= row; i++){
                for(int j=k; j<= col; j++){
                    int sum = prefixSum[i][j] - prefixSum[i-k][j] - prefixSum[i][j-k] + prefixSum[i-k][j-k];
                    if(w == sum){
                        return w;
                    }
                }
            }
        }
        return 0;
    }
}