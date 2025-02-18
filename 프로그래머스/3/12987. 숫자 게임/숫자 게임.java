import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        // 그리디 문제 아닌가?
        
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for(int n : B){
            tree.put(n, tree.getOrDefault(n,0) + 1);
        }
        
        // 
        for(int n : A){
            Integer best = tree.higherKey(n);
            if(best == null){
                // 가장 낮은 점수 감소
                best = tree.firstKey();
            }else{
                answer++;
            }
            
            tree.put(best, tree.get(best) - 1);
            if(tree.get(best) == 0){
                tree.remove(best);
            }
        }
        return answer;
    }
}