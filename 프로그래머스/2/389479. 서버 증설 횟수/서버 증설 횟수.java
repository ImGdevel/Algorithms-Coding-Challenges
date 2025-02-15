import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> server_d = new LinkedList<>();
        Stack<Integer> server = new Stack<>();
        
        for(int i=0; i<players.length; i++){
            
            // 현제 플레이어수 
            int count = players[i];
            
            // 증설할 서버수 비교
            int needServer = count / m;
            int serverCount = server.size();
            // 부족하다면 증설
            
            
            if(needServer > serverCount){
                for(int j = serverCount; j < needServer; j++){
                    server.push(1);
                    server_d.offer(i+k-1);
                    answer++;
                }
            }
            
            // 그 다음 놓아줄 서버 찾기
            while(!server_d.isEmpty() && server_d.peek() == i){
                server_d.poll();
                server.pop();
            }
        
        }
        
        return answer;
    }
}