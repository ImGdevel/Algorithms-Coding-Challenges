import java.util.*;

class Solution {
    
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(List<Edge>[] graph, int start) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.to;

            if (current.weight > dist[u]) continue;

            for (Edge edge : graph[u]) {
                int v = edge.to;
                int newDist = dist[u] + edge.weight;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.add(new Edge(v, newDist));
                }
            }
        }
        return dist;
    }
    
    
    public int solution(int n, int start, int a, int b, int[][] fares) {
        int answer = 0;
        
        List<Edge>[] graph = new List[n];
        for(int i =0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        
        for(int[] f : fares){
            int s = f[0] - 1;
            int e = f[1] - 1;
            int w = f[2];
            
            graph[s].add(new Edge(e, w));
            graph[e].add(new Edge(s, w));
        }
        
        int[][] dist = new int[n][];
        
        for(int i=0; i<n; i++){
            dist[i] = dijkstra(graph, i);
        }
        
        answer = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){

            answer = Math.min(answer ,dist[start-1][i] + dist[i][a-1] + dist[i][b-1]);
        }
        
        return answer;
    }
}