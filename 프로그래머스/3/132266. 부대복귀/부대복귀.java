import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        List<Integer>[] map = new List[n];
        
        for(int i=0; i<n;i++){
            map[i] = new ArrayList<>();
        }
        
        for(int[] road : roads){
            int start = road[0] - 1;
            int dest = road[1] - 1;
            map[start].add(dest);
            map[dest].add(start);
        }
        //BFS
        Queue<Integer> queue = new LinkedList<>();
        int[] check = new int[n];
        Arrays.fill(check, -1);
        // 초기화
        queue.offer(destination - 1);
        check[destination - 1] = 0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            int count = check[node] + 1;
            
            for(int next : map[node]){
                // 다음 노드가 방문 하지 않았다면?
                if(check[next] == -1){
                    queue.offer(next);
                    check[next] = count;
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
             answer[i] = check[sources[i]-1];
        }
        
        
        return answer;
    }
}