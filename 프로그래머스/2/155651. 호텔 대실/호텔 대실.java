import java.util.*;

class Solution {
    
    public int toTime(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] times = new int[book_time.length][2];
        int index = 0;
        for(String[] time : book_time){
            times[index][0] = toTime(time[0]);
            times[index][1] = toTime(time[1]) + 10;
            index++;
        }
        
        Arrays.sort(times, (a,b) -> a[0] - b[0]);
        
        List<Integer> rooms = new ArrayList<>();
        
        for(int[] time : times){
            
            boolean find = false;
            for(int i=0; i<rooms.size(); i++){
                int lastTime = rooms.get(i);
                if(lastTime <= time[0]){
                    rooms.set(i, time[1]);
                    find = true;
                    break;
                }
            }
            
            if(!find){
                rooms.add(time[1]);   
            }
        }
        
        
        return rooms.size();
    }
}