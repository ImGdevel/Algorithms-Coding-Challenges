import java.util.*;

class Solution {
    
    public int BFS(char[][] map, int[] s, int[] dest, int R, int C){
        int answer = -1;
        int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[R][C];
        
        queue.offer(new int[]{s[0], s[1]});
        check[s[0]][s[1]] = true;
        
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int k=0; k<size; k++){
                int[] node = queue.poll();
                
                for(int i=0; i<4; i++){
                    int nr = d[i][0] + node[0];
                    int nc = d[i][1] + node[1];

                    if(nr >=0 && nc >= 0 && nr < R && nc < C 
                       && !check[nr][nc] && map[nr][nc] != 'X'){
                        // 목표 지점이라면
                        if(nr == dest[0] && nc == dest[1]){
                            return count;
                        }
                        check[nr][nc] = true;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        int R = maps.length;
        int C = maps[0].length();
        char[][] map = new char[R][C];
        int[] start = new int[2];
        int[] lev = new int[2];
        int[] end = new int[2];
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                char ch = maps[i].charAt(j);
                map[i][j] = ch;
                if(ch == 'S'){
                    start[0] = i; start[1] = j;
                }else if(ch == 'L'){
                    lev[0] = i; lev[1] = j;
                }else if(ch == 'E'){
                    end[0] = i; end[1] = j;
                }
            }
        }
       
        int result;
        result = BFS(map, start, lev, R, C);
        if(result == -1){
            return -1;
        }
        answer += result;
        result = BFS(map, lev, end, R, C);
        if(result == -1){
            return -1;
        }
        answer += result;
        
        return answer;
    }
}