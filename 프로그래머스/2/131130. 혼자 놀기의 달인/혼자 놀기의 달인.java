import java.util.*;

class Solution {
    
    public int DFS(int[] cards, boolean[] check, int node){
        
        int nextNode = cards[node] - 1;
        check[node] = true;
        // 이미 방문한 노드라면
        if(check[nextNode]){
            return 1;
            // 방문 체크 후 귀환
        }
        // 아니라면 다음 노드로 진행
        return DFS(cards, check, nextNode) + 1;
    }
    
    public int solution(int[] cards) {
        int answer = 0;
        
        boolean[] check = new boolean[cards.length];
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i=0; i<cards.length; i++){
            if(!check[i]){
                int count = DFS(cards, check, i);
                pq.offer(count);
            }
        }
        
        if(pq.size() > 1){
            return pq.poll() * pq.peek();
        }
        
        return 0;
    }
}