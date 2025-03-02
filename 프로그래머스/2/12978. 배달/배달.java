import java.util.*;

class Solution {
    
    class Edge{
        int to;
        int weight;
        
        public Edge(int t, int w){
            to = t;
            weight = w;
        }
    }
    
    public int[] dijkstra(List<Edge>[] map, int N, int start){
        int[] dist = new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        
        Queue<Edge> pq = new PriorityQueue<>((a,b)->a.weight - b.weight);
        pq.offer(new Edge(start, 0));
        
        
        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int u = current.to;
            
            // 현재 노드에서 다음 노드로 
            for (Edge edge : map[u]) {
                int v = edge.to;
                int newDist = dist[u] + edge.weight;
                
                if(newDist < dist[v]){
                    dist[v] = newDist;
                    pq.offer(new Edge(v, newDist));
                }
            }
        }
        
        return dist;
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<Edge>[] map = new List[N];
        for(int i=0; i<N; i++){
            map[i] = new ArrayList<>();
        }
        
        
        for(int[] r: road){
            int s = r[0]-1;
            int e = r[1]-1;
            int w = r[2];
            map[s].add(new Edge(e,w));
            map[e].add(new Edge(s,w));
        }
        
        int[] list = dijkstra(map, N, 0);

        for(int n : list){
            if(n <= K){
                answer++;
            }
        }
        
        return answer;
    }
}