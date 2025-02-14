class Solution {
    boolean solution(String s) {        
        int open = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                open++; 
                continue;
            }
            
            open--;
            if(open < 0){
                return false;
            }
        }

        return open == 0 ? true : false;
    }
}