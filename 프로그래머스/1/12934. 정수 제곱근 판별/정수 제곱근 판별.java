//import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        double p = Math.sqrt(n);
        
        
        
        if(n % p == 0){
            return (long)Math.pow(p + 1, 2);
        }else{
            return -1;
        }
        
    }
}