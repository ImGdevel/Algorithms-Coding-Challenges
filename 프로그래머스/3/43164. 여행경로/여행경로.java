import java.util.*;

class Solution {
    
    static boolean find = false;
    
    void DFS(String[][] tickets, String current, int count, int N, boolean[] used, Stack<String> order){
        order.push(current);
        //System.out.println(current);
        if(count >= N){
            // 모든 노드 방문! 정답 찾음
            find = true;
            return;
        }
        
        for(int i=0; i<N; i++){
            //System.out.println((!used[i] && tickets[i][0].equals(current)) + " " + tickets[i][1]);
            if(!used[i] && tickets[i][0].equals(current)){
                String next = tickets[i][1];
                used[i] = true;
                DFS(tickets, next, count+1, N, used, order);
                if(find){
                    return;
                }
                used[i] = false;
            }
        }
        System.out.println("pop!");
        order.pop();
    }
    
    public String[] solution(String[][] tickets) {
        int N = tickets.length;
        boolean[] used = new boolean[N];
        Stack<String> order = new Stack<>();
        Arrays.sort(tickets, (a,b)->{
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        DFS(tickets, "ICN", 0, N, used, order);
        
        String[] answer = new String[order.size()];
        int index = order.size() - 1;
        while(!order.isEmpty()){
            answer[index--] = order.pop();        
        }
      
        
        return answer;
    }
}