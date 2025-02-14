import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville){
            pq.offer(n);
        }
        
        while(pq.peek() < K){
            int a = pq.poll();
            if(pq.isEmpty()){
                return -1;
            }
            int b = pq.poll();
            int c = a + b * 2;
            answer++;
            pq.offer(c);
        }
        
        return answer;
    }
}