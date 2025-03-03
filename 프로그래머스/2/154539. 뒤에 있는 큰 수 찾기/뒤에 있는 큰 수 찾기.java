import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{numbers[0], 0});
        
        for(int i=1; i<N; i++){
            int num = numbers[i]; //현재 값이
            
            // stack의 peek값보다 크다면?
            while(!stack.isEmpty() && stack.peek()[0] < num){
                int[] x = stack.pop();
                answer[x[1]] = num;
            }
            
            stack.push(new int[]{num, i});
        }
        
        
        return answer;
    }
}