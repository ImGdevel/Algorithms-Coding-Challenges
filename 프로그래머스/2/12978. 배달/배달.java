import java.util.*;

class Solution {
    
    public int[] dickstra(List<int[]>[] graph, int N, int start){
        
        Queue<Integer> pq = new PriorityQueue<>();
        int[] dist = new int[N];
        Arrays.fill(dist, 1000000000);
        
        pq.offer(start);
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            int u = pq.poll();    
            int value = dist[u];
            
            for(int[] next : graph[u]){
                int v = next[0];
                int w = value + next[1];
                
                if(dist[v] > w){
                    dist[v] = w;
                    pq.offer(v);
                }
            }   
        }
        
        return dist;
    }
    
    
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<int[]>[] graph = new List[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        
        
        
        for(int[] n : road){
            int s = n[0] - 1;
            int e = n[1] - 1;
            int w = n[2];
            graph[s].add(new int[]{e,w});
            graph[e].add(new int[]{s,w});
        }
        
        int[] dist = dickstra(graph, N, 0);
        for(int n : dist){
            if(n <= K){
                answer++;
            }
        }

        return answer;
    }
}