class Solution {
    
    void BF(StringBuilder str, Character[] index, String target, int[] answer){
        if(str.length() >= 5){
            return;
        }
        
        int si = str.length();
        str.append(" ");
        for(int i=0; i<5 && answer[1] == 0; i++){
            str.setCharAt(si ,index[i]);
            answer[0]++;
            if(target.equals(str.toString())){
                answer[1] = 1;
                return;
            }
            if(answer[1] == 0){
                BF(str, index, target, answer);
            }
        }
        str.deleteCharAt(si);
    }
    
    public int solution(String word) {
        int[] answer = new int[2];
        Character[] index = new Character[]{'A','E','I','O','U'};
        StringBuilder str = new StringBuilder();
        
        BF(str,index,word,answer);
        
        
        return answer[0];
    }
}