class Solution {
    public int solution(int n) {
        if(n % 2 == 1){
            return 0;
        }
        int N = n / 2;
        long MOD = 1000000007;
        long[] dp = new long[N+1];
        long[] sum = new long[N+1];
        
        dp[0] = 1; dp[1] = 3;
        sum[1] = 1;
        
        for(int i=2; i<=N; i++){
            dp[i] = (3 * dp[i-1] + 2 * sum[i-1]) % MOD;  
            sum[i] = (dp[i-1] + sum[i-1]) % MOD;
            //System.out.println( (i * 2) + " " +  dp[i] + " " + sum[i-1]);
        }
        
        return (int)dp[N];
    }
}