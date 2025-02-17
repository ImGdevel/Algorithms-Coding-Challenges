import java.util.*;

class Solution {
    
    public long pi(int n){
        long sum = 1;
        for(int i=2; i<=n; i++){
            sum *= i;
        }
        return sum;
    }
    
    public int[] solution(int n, long k) {
        // 사실은 수학 문제?
        long num = k - 1;
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[n];
        for(int i=1; i <=n; i++){
            list.add(i);   
        }
        
        for(int i=0; i<n; i++){
            long splitNum = pi(n - i - 1);
            int dim = (int)(num / splitNum);
            int x = list.get(dim);
            answer[i] = x;
            list.remove(dim);
            
            num %= splitNum;
        }
        return answer;
    }
}