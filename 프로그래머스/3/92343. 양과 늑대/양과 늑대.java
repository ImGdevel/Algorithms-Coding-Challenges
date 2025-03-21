import java.util.*;

class Solution {
    
    class Node{
        
        int visited;
        int sheep;
        int wolf;
        
        public Node(int v, int s, int w){
            visited = v; sheep = s; wolf = w;
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        int answer = 1;
        
        // 지금까지 방문한 모든 노드들의 리프 노드를 찾아가는 것을 시작
        // 중첩이 되는가? 
        int N = info.length;
        List<Integer>[] list = new List[N];
        
        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i < edges.length; i++){
            int s = edges[i][0];
            int e = edges[i][1];
            
            list[s].add(e);
        }
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1,1,0));
        
        while(!q.isEmpty()){
            Node node = q.poll();
            // 모든 리프 노드들 중 갈 수 있는 곳 탐색
            for(int i=0; i<N; i++){
                
                if((node.visited & (1 << i)) != 0 ){
                    // i번 노드 방문
                    // 그의 자식들은 방문? 
                    for(int next : list[i]){
                        // 아직 방문 x & 
                        if((node.visited & (1 << next)) == 0){
                            if(info[next] == 0){
                                q.offer(new Node(node.visited | (1 << next), node.sheep + 1, node.wolf));
                                answer = Math.max(node.sheep + 1 , answer);
                            }else if(info[next] == 1 && node.sheep > node.wolf + 1){
                                q.offer(new Node(node.visited | (1 << next), node.sheep, node.wolf + 1));
                            }
                        }
                    }
                } 
            }
        }
        
        
        return answer;
    }
}