import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int manCount = schedules.length;
        boolean[] check = new boolean[manCount];
        Arrays.fill(check, true);
        
        for(int i=0; i<7; i++){
            
            // 주말이면 제외
            if((startday - 1 + i) % 7 > 4 ){
                continue;
            }
            
            for(int m =0; m<manCount; m++){
                int limit = toTime(schedules[m]) + 10;
                int in = toTime(timelogs[m][i]);
                if(in > limit){
                    check[m] = false;
                }
            }
        }
        
        for(boolean c : check){
            answer += (c) ? 1 : 0;   
        }
        
        return answer;
    }
    
    int toTime(int n){
        return (n / 100) * 60 + (n % 100);
    }
    
}