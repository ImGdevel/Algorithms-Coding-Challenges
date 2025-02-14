import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(strNumbers, (a,b) -> (b+a).compareTo(a+b));
        
        String answer = String.join("", strNumbers);
        if (answer.startsWith("0")) return "0";
        return answer;
    }
}