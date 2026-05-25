class Solution {
    public int[] solution(int[] arr, int[][] q) {
        
        int len = q.length;
        for(int i=0; i < len; i++){
            int s = q[i][0];
            int e = q[i][1];
            
            for(int k = s; k <= e; k++){
                arr[k]++;
            }
        }
        
        
        return arr;
    }
}