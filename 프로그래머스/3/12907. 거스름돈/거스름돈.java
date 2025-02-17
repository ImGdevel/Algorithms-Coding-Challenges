class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        int MOD = 1000000007;
        dp[0] = 1;
        for(int k=0; k<money.length; k++){
            int m = money[k];
            for(int i = m; i <= n; i++){
                dp[i] = dp[i-m] + dp[i] % MOD;
            }
        }
        
        return dp[n];
    }
}