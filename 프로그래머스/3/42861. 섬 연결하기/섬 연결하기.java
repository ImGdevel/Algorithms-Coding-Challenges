import java.util.*;

class Solution {
    // 유니온 파인드와 크루스칼
    int find(int[] parent, int n){
        if(parent[n] != n){
            parent[n] = find(parent, parent[n]);
        }
        return parent[n];
    }
    
    void union(int[] parent, int[] rank, int a, int b){
        a = find(parent, a);
        b = find(parent, b);
        
        if(a != b){
            if(rank[a] < rank[b]){
                parent[b] = a;
            }else if(rank[b] < rank[a]){
                parent[a] = b;
            }else{
                parent[a] = b;
                rank[b]++;
            }
        }
    }
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a,b)->a[2]-b[2]);
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        int total = 0;
        for(int[] cost : costs){
            int a = find(parent, cost[0]);
            int b = find(parent, cost[1]);
            int w = cost[2];
            
            if(a != b){
                total += w;
                union(parent, rank, a, b);
            }
        }
        
        return total;
    }
}