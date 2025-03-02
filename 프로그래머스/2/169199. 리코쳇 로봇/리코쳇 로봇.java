import java.util.*;

class Solution {
    
    int BFS(char[][] map, int R, int C, int[] start){
        int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[R+2][C+2];
        int count = 0;
        queue.offer(start);
        check[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] node = queue.poll();
                
                for(int k = 0; k< 4; k++){
                    int nr = node[0], nc = node[1];
                    
                    // 해당 방향으로 D를 만날때까지 이동
                    while(map[nr + d[k][0]][nc + d[k][1]] != 'D'){
                        nr += d[k][0];
                        nc += d[k][1];    
                    }
                    // 이미 방문한 노드라면?
                    if(check[nr][nc]){
                        continue;
                    }
                    if(map[nr][nc] == 'G'){
                        return count;   
                    }
                    queue.offer(new int[]{nr,nc});
                    check[nr][nc] = true;
                    
                }
            }
        }
        return -1;
    }
    
    
    public int solution(String[] board) {
        int answer = 0;
        int R = board.length;
        int C = board[0].length();
        char[][] map = new char[R+2][C+2];
        int[] start = new int[2];
        
        for(int i=0; i<R+2; i++){
            for(int j=0; j<C+2; j++){
                if(i==0 || j == 0 || i == R + 1 || j == C + 1){
                    map[i][j] = 'D';
                    continue;
                }
                else if(board[i-1].charAt(j-1) == 'R'){
                    start[0] = i; start[1] = j;
                }
                map[i][j] = board[i-1].charAt(j-1);
            }
        }
        
        answer = BFS(map, R, C, start);
        
        return answer;
    }
}