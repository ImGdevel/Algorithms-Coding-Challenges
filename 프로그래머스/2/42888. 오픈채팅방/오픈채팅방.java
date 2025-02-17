import java.util.*;

class Solution {
    
    
    
    public String[] solution(String[] record) {
        Map<String, String> userId = new HashMap<>();
        List<String[]> chatMap = new ArrayList<>();
        
        for(String commands : record){
            String[] command = commands.split(" ");
            String op = command[0];
            String uid = command[1];
            
            if("Enter".equals(op)){
                chatMap.add(new String[]{uid , "들어왔습니다."});
                userId.put(uid, command[2]);
            }else if("Leave".equals(op)){
                chatMap.add(new String[]{uid , "나갔습니다."});
            }else if("Change".equals(op)){
                userId.put(uid, command[2]);
            }
        }
        
        String[] chat = new String[chatMap.size()];
        // 이름 매핑
        int index = 0;
        for(String[] str : chatMap){
            String uid = userId.get(str[0]);
            chat[index++] = uid + "님이 " + str[1];
        }
        
        return chat;
    }
}