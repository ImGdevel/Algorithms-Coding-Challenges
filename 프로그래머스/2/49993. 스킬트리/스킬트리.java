class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // 찾아보기
        for(String tree : skill_trees){
            
            // 검사
            int end = tree.length();
            boolean find = false;
            boolean good = true;
            for(int i=skill.length() - 1; i >= 0; i--){
                String ch = String.valueOf(skill.charAt(i));
                int index = tree.lastIndexOf(ch, end);
                if(!find && index == -1){
                    continue;
                } else if(find && index == -1){
                    good = false;
                    break;
                } else{
                    end = index;
                    find = true;
                }
                 //System.out.println(ch + " " + index);
            }
            
            
            
            if(good){
                answer++;
            }
            
        }
        
        
        return answer;
    }
}