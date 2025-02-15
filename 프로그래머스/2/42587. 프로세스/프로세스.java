import java.util.*;

class Solution {
    
    class Task{
        int pri;
        int loc;
        public Task(int p, int l){
            this.pri = p;
            this.loc = l;
        }
    }
    
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Task> queue = new LinkedList<>();
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i=0; i<priorities.length; i++){
            Task task = new Task(priorities[i], i);
            queue.offer(task);
            pq.offer(priorities[i]);
        }
        
        while(!queue.isEmpty()){
            Task task = queue.poll();
            
            if(task.pri == pq.peek()){
                pq.poll();
                answer++;
                if(location == task.loc){
                    break;
                }
            }else{
                queue.offer(task);
            }
            
        }
        
        return answer;
    }
}