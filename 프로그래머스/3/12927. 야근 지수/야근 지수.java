import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        int leftTime = n;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int t : works){
            pq.offer(t);
        }
        
        while(leftTime > 0 && !pq.isEmpty()){
            int bestLoogTime = pq.poll();
            bestLoogTime--;
            leftTime--;
            if(bestLoogTime > 0){
                pq.offer(bestLoogTime);
            }
        }
        
        long answer = 0;
        for(long t : pq){
            answer += Math.pow(t,2);
        }
        
        return answer;
    }
}