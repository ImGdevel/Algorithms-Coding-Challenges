import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] arr: clothes){
            String type = arr[1];
            String content = arr[0];
            map.put(type, map.getOrDefault(type, 0) + 1);

        }
        
        int value = 1;
        for (int count : map.values()) {
            value *= (count + 1);
        }
        
        return value - 1;
    }
}