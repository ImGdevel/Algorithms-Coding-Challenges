import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int[][] floyd = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(floyd[i], Integer.MAX_VALUE);
            floyd[i][i] = 0;
        }
        
        for(int[] r : road){
            int s = r[0] - 1;
            int e = r[1] - 1;
            int w = r[2];
            
            floyd[s][e] = Math.min(w, floyd[s][e]);
            floyd[e][s] = Math.min(w, floyd[s][e]);
        }
        
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if (floyd[i][k] != Integer.MAX_VALUE && floyd[k][j] != Integer.MAX_VALUE) {
                        floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                    }
                }
            }
        }
        
        for(int n : floyd[0]){
            if(n <= K){
                answer++;
            }
        }
        

        return answer;
    }
}