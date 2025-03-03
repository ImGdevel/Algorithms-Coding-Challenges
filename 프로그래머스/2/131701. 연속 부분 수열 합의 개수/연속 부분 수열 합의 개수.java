import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        // 누적합으로 구현?
        int N = elements.length;
        int[] prefix = new int[N*2];
        
        for(int i=1; i < N*2; i++){
            prefix[i] = elements[i % N] + prefix[i-1];
        }
        
        Set<Integer> set = new HashSet<>();
        for(int k = 1; k <= N; k++){
            for(int i=0; i<N; i++){
                int sum = prefix[i + k] - prefix[i];
                set.add(sum);
            }
        }
        // 중복제거는 set으로
        
        return set.size();
    }
}