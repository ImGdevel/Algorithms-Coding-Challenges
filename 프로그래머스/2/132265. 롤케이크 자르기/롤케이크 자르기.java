import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> young = new HashMap<>();
        Map<Integer, Integer> old = new HashMap<>();
        for(int n : topping){
            old.put(n, old.getOrDefault(n, 0) + 1);
        }
        
        for(int i=0; i<topping.length ; i++){
            int top = topping[i];
            old.put(top, old.get(top) - 1);
            if(old.get(top) == 0 ){ old.remove(top); }
            
            young.put(top, old.getOrDefault(top, 0) + 1);
            if(old.size() == young.size()){
                answer++;
            }
        }
        
        
        return answer;
    }
}