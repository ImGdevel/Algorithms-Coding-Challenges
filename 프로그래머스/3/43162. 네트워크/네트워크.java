class Solution {
    
    void DFS(int current_node, int[][] computers, boolean[] visited){
        visited[current_node] = true;
        
        for(int i=0; i<computers[current_node].length; i++){
            if(!visited[i] && computers[current_node][i] == 1 ){
                DFS(i, computers, visited);
            }    
        }
    }
    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i < computers.length; i++){
            if(!visited[i]){
                answer++;
                DFS(i, computers, visited);    
            }
        }
        
        return answer;
    }
}