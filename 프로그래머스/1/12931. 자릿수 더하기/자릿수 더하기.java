import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = Integer.toString(n);

        int sum = 0;
        for (char c : str.toCharArray()) {
            sum += c - '0';
        }

        return sum;
    }
}