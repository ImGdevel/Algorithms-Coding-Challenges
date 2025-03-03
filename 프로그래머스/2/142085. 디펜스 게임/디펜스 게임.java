import java.util.*;

class Solution {
    public int solution(int hp, int k, int[] enemy) {
        int answer = 0;
        
        int N = enemy.length;
        int damage = 0; //누적 데미지
        Queue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        
        for(int i=0; i<N; i++){
            damage += enemy[i]; //데미지 누적
            pq.offer(enemy[i]);
            
            while(damage > hp){ //누적 데미지가 초과되면!
                if(k > 0){
                    //무적권 사용!
                    k--;
                    damage -= pq.poll();
                }else{
                    //사용할수 없다면 라운드 종료
                    return answer;
                }
            }
            
            answer++;
        }
        
        
        return answer;
    }
}