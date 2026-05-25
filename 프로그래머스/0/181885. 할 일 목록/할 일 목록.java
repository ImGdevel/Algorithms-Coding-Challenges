import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int len = todo_list.length;
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<len; i++){
            if(!finished[i]){
                answer.add(todo_list[i]);
            }
        }
        return answer.toArray(new String[0]);
    }
}