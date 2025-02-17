import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a,b)-> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });
        
        int index = 0;
        while(index < routes.length){
            
            answer++;
            int point = routes[index][1];
            index++;
            while(index < routes.length && routes[index][0] <= point){
                index++;
            }
        }
        
        
        
        return answer;
    }
}