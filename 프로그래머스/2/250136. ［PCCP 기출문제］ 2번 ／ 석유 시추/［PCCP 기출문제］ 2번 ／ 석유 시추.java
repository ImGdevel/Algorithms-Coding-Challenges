import java.util.*;

class Solution {
    
    // 기름양 계산
    int BFS(int[][] land, int X, int H, int[] start, boolean[][] visit, int oilNo){
        int[][] d = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        int count = 0;
        
        queue.offer(start);
        visit[start[0]][start[1]] = true;
         
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            
            list.add(new int[]{pos[0], pos[1]});
            count++;
            
            for(int i=0; i<4; i++){
                int nr = d[i][0] + pos[0];
                int nc = d[i][1] + pos[1];
                
                if(nr >= 0 && nc >= 0 && nr < H && nc < X && !visit[nr][nc] && land[nr][nc] != 0){
                    queue.offer(new int[]{nr, nc});
                    visit[nr][nc] = true;
                }
            }
        }
        
        for(int[] p : list){
            land[p[0]][p[1]] = oilNo;
        }
        
        return count;
    }
    
    
    //시추해서 찾기
    int findOil(int[][] land, int pos, int H, List<Integer> oilList){
        int oil = 0;
        Set<Integer> set = new HashSet<>();
        for(int h=0; h<H; h++){
            int o = land[h][pos];
            if(o != 0){
                set.add(o);
            }
        }
        
        for(int no : set){
            oil += oilList.get(no-1);
        }
        
        return oil;
    }
    
    
    public int solution(int[][] land) {
        int answer = 0;
        int X = land[0].length;
        int H = land.length;
        
        boolean[][] visit = new boolean[H][X];
        
        List<Integer> oilList = new ArrayList<>();
        int oilNo = 1;
        
        for(int i=0; i<H; i++){
            for(int j=0; j<X; j++){
                if(!visit[i][j] && land[i][j] != 0){
                    oilList.add(BFS(land, X, H, new int[]{i,j}, visit, oilNo));
                    oilNo++;
                }
            }
        }
        
        
        for(int i=0; i<X; i++){
            int n = findOil(land, i, H, oilList);
            answer = Math.max(answer, n);
        }
        
        return answer;
    }
}