import java.util.*;

class Solution {
    
    int BFS(String[] map, int R, int C, int[] start, boolean[][] visit){
        int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> queue= new LinkedList<>();
        int count = 0;
        queue.offer(new int[]{start[0],start[1]});
        visit[start[0]][start[1]] = true;
        count += map[start[0]].charAt(start[1]) - '0';
        
        while(!queue.isEmpty())
        {
            int[] node = queue.poll();
            
            for(int i=0; i<4; i++){
                int nr = d[i][0] + node[0];
                int nc = d[i][1] + node[1];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C || visit[nr][nc] || map[nr].charAt(nc) == 'X'){
                    continue;
                }
                queue.offer(new int[]{nr,nc});
                visit[nr][nc] = true;
                count += map[nr].charAt(nc) - '0';
            }
            
        }
        return count;
    }
    
    
    public int[] solution(String[] maps) {
        int R = maps.length;
        int C = maps[0].length();
        boolean[][] visit = new boolean[R][C];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;  i < R ; i++){
            for(int j=0; j < C; j++){
                if(!visit[i][j] && maps[i].charAt(j) != 'X'){
                    int n = BFS(maps, R, C, new int[]{i,j}, visit);
                     list.add(n);
                }
            }
        }
        if(list.isEmpty()){
            return new int[]{-1};
        }
        list.sort((a,b)->a-b);
        return list.stream().mapToInt(i->i).toArray();
    }
}