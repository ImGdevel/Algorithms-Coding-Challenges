import java.util.*;

class Solution {

    class Edge{
        int s;
        int e;
        int w;
        
        public Edge(int s, int e, int w){
            this.s = s; this.e = e; this.w = w;
        }
    }
    
    int INF = Integer.MAX_VALUE;
    
    public int[] BF(List<Edge> eg, int N, int start){
        
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        for(int i=0; i<N-1; i++){
            for(Edge e : eg){
                if(dist[e.s] != INF && dist[e.s] + e.w < dist[e.e]){
                    dist[e.e] = dist[e.s] + e.w;
                }
                if(dist[e.e] != INF && dist[e.e] + e.w < dist[e.s]){
                    dist[e.s] = dist[e.e] + e.w;
                }
                
            }
            //System.out.println(Arrays.toString(dist));
        }
        
        return dist;
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<Edge> eg = new ArrayList<>();
        
        for(int[] r : road){
            int s = r[0] - 1;
            int e = r[1] - 1;
            int w = r[2];
            eg.add(new Edge(s,e,w));
        }
        
        int[] dist = BF(eg, N, 0);
        
        //System.out.println(Arrays.toString(dist));
        
        for(int d : dist){
            if(d <= K){
                answer++;
            }
        }
        
        return answer;
    }
}