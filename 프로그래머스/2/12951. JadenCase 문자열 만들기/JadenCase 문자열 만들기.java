import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        boolean changeUpperRead = true;
        for(Character ch : s.toCharArray()){
            if(ch == ' '){
                changeUpperRead = true;
                answer.append(ch);
            }else if(changeUpperRead){
                answer.append(Character.toUpperCase(ch));
                changeUpperRead = false;
            }else{
                answer.append(Character.toLowerCase(ch));
            }
        }
        
        return answer.toString();
    }
}