import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        
        // 중족검사 = Hash
        char lastChar = words[0].charAt(0);
        for(int i=0; i<words.length; i++){
            String word = words[i];
            // 단어를 말하면
            // 1. 마지막 글자 가 같은가?
            // 2. 이미 사용한 단어인가?
            if(set.contains(word) || word.charAt(0) != lastChar){
                return new int[]{i % n + 1, i / n + 1};
            }
            
            // 전부 아니라면 등록하고 다음번호로
            set.add(word);
            lastChar = word.charAt(word.length() - 1);
        }
        
        return new int[]{0,0};
    }
}