import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1Sum = 0, q2Sum = 0;
        
        for (int num : queue1){
            q1.add(num);
            q1Sum += num;
        } 
        for (int num : queue2) {
            q2.add(num);
            q2Sum += num;
        }
        
        if((q1Sum + q2Sum) % 2 != 0) return -1;
        
        int answer = 0;
        int maxCount = (queue1.length + queue2.length) * 2;
        for(int i=0; i <= maxCount; i++){
            if(q1Sum == q2Sum){
                return answer;
            }
            else if(q1Sum < q2Sum){
                int n = q2.poll();
                q2Sum -= n;
                q1Sum += n;
                q1.offer(n);
            }
            else {
                int n = q1.poll();
                q1Sum -= n;
                q2Sum += n;
                q2.offer(n);
            }
            answer++;
        }
        
        
        return -1;
    }
}