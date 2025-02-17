import java.util.*;

class Solution {
    
    public void checkBorad(int[] board, boolean[] check, int pos){
        // 대각선 계산
        // 현제 인덱스가 2이고
        // NQ가 1위치에 있다면? 차이값은 1 그러면 0과 2는 불가능
        for(int i=0; i<board.length; i++){
            int NQPos = board[i];    
            if(NQPos == -1){
                continue;
            }
            int k = pos - NQPos;
            check[i] = true;
            if(i-k >= 0) check[i - k] = true;
            if(i+k < board.length) check[i + k] = true;
        }
    }
    
    public int NQ(int n, int[] board, int count){
        // 종료 조건
        if(count >= n){
            //System.out.println(Arrays.toString(board));
           return 1; 
        }
        int answer = 0;
        boolean[] check = new boolean[n];
        checkBorad(board, check, count);
        
        for(int i=0; i<board.length; i++){
            if(!check[i]){ //둘 수 있는자리
                board[i] = count;
                answer += NQ(n, board, count + 1);
                board[i] = -1;
            }
        }
        return answer;
    }
    
    public int solution(int n) {
        int answer = 0;
        
        int[] board = new int[n];
        Arrays.fill(board, -1);
        
        return NQ(n, board, 0);
    }
}