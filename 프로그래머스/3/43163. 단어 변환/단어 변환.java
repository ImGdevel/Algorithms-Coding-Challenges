import java.util.*;

class Solution {
    
    
    // 단어를 가져오면 연관 관계에 있는 단어 인덱스를 리턴
    
    // 닮은 단어 리스트
    List<Integer> simWords(String begin, String[] words){
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<words.length; i++){
            String word = words[i];
            int count = 0;
            for(int k=0; k<begin.length(); k++){
                if(word.charAt(k) != begin.charAt(k)){
                    count++;
                }
            }
            if(count <= 1){
                list.add(i);    
            }
        }
        
        return list;
    }
    
    public int solution(String begin, String target, String[] words) {
        //제한 단어 3~10
        // words 3이상 50이하
        
        
        // word 그래프 만들기
        List<Integer>[] map = new ArrayList[words.length];
        int i=0;
        for(String w : words){
            map[i++] = simWords(w, words);
        }
        
        // words중에서 begin과 비슷한 단어 찾기
        List<Integer> start = simWords(begin, words);
        Queue<Integer> queue = new LinkedList<>();
        
        // 초기화
        for(int n : start){
            queue.offer(n);
        }

        // BFS 적용
        int count = 0;
        while(!queue.isEmpty() && count < words.length){
            count++;
            
            int size = queue.size();
            for(int x=0; x<size; x++){
                int node = queue.poll();
                String word = words[node];
                if(word.equals(target)){
                    return count;  
                }
                
                for(int next : map[node]){
                    queue.offer(next);
                } 
            }
        }
        
        
        return 0;
    }
    
    
}