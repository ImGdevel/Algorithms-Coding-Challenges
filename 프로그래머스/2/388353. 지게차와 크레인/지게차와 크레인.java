import java.util.*;

class Solution {
    
    public int removeOuter(char[][] area, char target, int R, int C){
        int[][] d = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[R+2][C+2];
        int count = 0;

        queue.offer(new int[]{0,0});
        check[0][0] = true;
         
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            
            for(int i=0; i<4;i++){
                int nr = d[i][0] + node[0];
                int nc = d[i][1] + node[1];
                if(nr >= 0 && nc >= 0 && nr < R + 2 && nc < C + 2
                  && !check[nr][nc]){
                    
                    check[nr][nc] = true;
                    if(area[nr][nc] == target){
                        area[nr][nc] = 0;
                        count++;
                    }else if(area[nr][nc] == 0){
                        queue.offer(new int[]{nr,nc});
                    }
                }
                
            }
        }
        //System.out.println(count);
        return count;
    }
    
    public int removeAll(char[][] area, char target, int R, int C){
        int count = 0;
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(area[i][j] == target){
                    count++;
                    area[i][j] = 0;
                }
            }
        }
        System.out.println(count);
        return count;
    }
    
    public void print(char[][] area,int R, int C){
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                System.out.print(area[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        int R = storage.length;
        int C = storage[0].length();
        int answer = R*C;
        char[][] area = new char[R+2][C+2];
        
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C;j++){
                area[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        
        // 요청처리
        for(String request : requests){
            char ch = request.charAt(0);
            if(request.length() == 1){
                // 외부 삭제
                answer -= removeOuter(area, ch, R, C);
            }else{
                //전체 삭제
                answer -= removeAll(area, ch, R, C);
            }
            
            //print(area, R, C);
        }
        
        return answer;
    }
}