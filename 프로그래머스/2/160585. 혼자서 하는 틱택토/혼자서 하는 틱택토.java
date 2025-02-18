class Solution {
    
    public boolean isFinished(String[] board, char ch){
        String line = String.valueOf(ch).repeat(3);
        
        for(int i =0;i<3; i++){
            if(line.equals(board[i])){
              return true;
            } 
            if(board[0].charAt(i) ==  board[1].charAt(i) && 
                board[1].charAt(i) == board[2].charAt(i) &&
                board[0].charAt(i) == ch){
                return true;
            }
        }
        if((board[0].charAt(0) ==  board[1].charAt(1) && 
                board[1].charAt(1)== board[2].charAt(2) &&
                board[1].charAt(1) == ch)){
                return true;
        }
        if((board[2].charAt(0) ==  board[1].charAt(1) && 
                board[1].charAt(1)== board[0].charAt(2) &&
                board[1].charAt(1) == ch)){
                return true; 
        }
        return false;
    }
    
    public int solution(String[] board) {
        int answer = -1;
        int OCount = 0,  XCount = 0;
        
        // 개수 세기
        for(int i =0;i<3; i++){
            for(int j=0; j<3; j++){
                char ch = board[i].charAt(j);
                if(ch =='X') XCount++;
                if(ch == 'O') OCount++;
            }
        }
        
        //이미 종료된 게임인가?
        boolean OWin = isFinished(board, 'O');
        boolean XWin = isFinished(board, 'X');
        
        // 개수가 정상적인가?
        if(!(OCount == XCount || OCount == XCount + 1)){
            return 0;
        }
        
        // 둘다 이김
        if(OWin && XWin){
            return 0;
        }
        
        // O가 이기면 O가 한개 더 많아야함
        if(OWin && OCount != XCount + 1 ){
            return 0;
        }
        // 반대
        if(XWin && OCount != XCount){
            return 0;
        }
        
        
        return 1;
    }
}