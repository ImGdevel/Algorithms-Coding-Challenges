import java.util.*;

class Solution {
    
    boolean isCheck(int[] rocks, int k, int n, int dest){
        int prev = 0;
        int removed = 0;
        
        for (int rock : rocks) {
            if (rock - prev < k) { 
                removed++;
                if (removed > n) return false;
            } else {
                prev = rock;
            }
        }
        
        if (dest - prev < k) {
            removed++;
            if (removed > n) return false;
        }

        return true;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0; 
        int right = distance;
        Arrays.sort(rocks);
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(isCheck(rocks, mid, n, distance)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return answer;
    }
}