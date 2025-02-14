class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int MOD =  1000000007;
        int[][] map = new int[m+1][n+1];
        map[1][1] = 1;
        boolean[][] puddlesChk = new boolean[m+1][n+1];
        
        for(int i=0; i<puddles.length; i++){
            int r = puddles[i][0];
            int c = puddles[i][1];
            puddlesChk[r][c] = true;
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(puddlesChk[i][j]) continue;
                map[i][j] += (map[i-1][j] + map[i][j-1]) % MOD;
            }
        }
        
        return map[m][n];
    }
}