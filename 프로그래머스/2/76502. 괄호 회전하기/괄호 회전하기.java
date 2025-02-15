import java.util.*;

class Solution {
    boolean checkByStack(String str){
        Stack<Character> stk = new Stack<>();
        
        for(char ch : str.toCharArray()){
            switch (ch) {
                case '(': case '{': case '[':
                    stk.push(ch);
                    break;
                case ')':
                    if (stk.isEmpty() || stk.peek() != '(') return false;
                    stk.pop();  
                    break;
                case '}':
                    if (stk.isEmpty() || stk.peek() != '{') return false;
                    stk.pop();  
                    break;
                case ']':
                    if (stk.isEmpty() || stk.peek() != '[') return false;
                    stk.pop();
                    break;
            }
        }
        
        return (stk.isEmpty())? true : false;
    }
    
    public int solution(String s) {
        int answer = 0;
        StringBuilder str = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            answer += checkByStack(str.toString()) ? 1 : 0;
            str.append(str.charAt(0));
            str.delete(0,1);
        }
        
        return answer;
    }
}