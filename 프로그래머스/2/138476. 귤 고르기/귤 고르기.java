import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // Map이용
        Map<Integer,Integer> box = new HashMap<>();
        for(int n : tangerine){
            box.put(n, box.getOrDefault(n, 0) + 1);
        }
        
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); 
        for(Map.Entry<Integer,Integer> m : box.entrySet()){
            pq.offer(m.getValue());
        }
        
        int count = 0;
        while(count < k && !box.isEmpty()){
            count += pq.poll();
            answer++;
        }
        
        return answer;
    }
}