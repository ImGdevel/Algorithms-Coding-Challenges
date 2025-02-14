import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!stk.isEmpty() && ch == stk.peek()){
                stk.pop();
            }else{
                stk.push(ch);
            }
        }
        return stk.isEmpty() ? 1 : 0;
    }
}