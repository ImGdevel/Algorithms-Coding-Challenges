class Solution {
    
    //분할 정복
    // 최대 시간 복잡도 O(N^2) = 누적합 계산하는 복잡도 한번
    
    void divide(int[][] arr, int[][] prefix, int x, int y, int n, int[] answer){
        int num = arr[x-1][y-1];
        //System.out.println(n + " -> "+ x + ":" + y + "~" + (x+n-1) + ":" + (y+n-1) );
        if(n == 1){
            answer[num]++;
            return;
        }
        
        // 압축가능?
        int area = prefix[x+n-1][y+n-1] - prefix[x+n-1][y-1] - prefix[x-1][y+n-1] + prefix[x-1][y-1];
        if(num == 0 && area == 0){
            // 0 압축
            answer[num]++;
            return;
        }
        
        if(num == 1 && n*n == area){
            // 1압축
            answer[num]++;
            return;
        }
        
        // 분할
        int div = n/2;
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                divide(arr, prefix, x + i * div, y + j * div, div, answer);
            }
        }
        
    }
    
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = arr.length;
        int[][] prefix = new int[n + 1][n + 1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                prefix[i][j] = arr[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];    
            }
        }
        divide(arr, prefix, 1, 1, n, answer);
        return answer;
    }
}