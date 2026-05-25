import java.util.*;

class Solution {
    
    public int prim(int n){
        
        int count = n - 1;
        boolean arr[] = new boolean[n + 1];
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        
        for(int i=2; i * i < n; i++){
            if(arr[i]){
                for(int j = i + i; j <= n; j += i){
                    if(arr[j]){
                        count--;
                        //System.out.println(j);
                        arr[j] = false;    
                    }
                }
            }
        }
        
        
        
        
        
        
        
        
        return count;
    }
    
    
    public int solution(int n) {
        
        return prim(n);
    }
}