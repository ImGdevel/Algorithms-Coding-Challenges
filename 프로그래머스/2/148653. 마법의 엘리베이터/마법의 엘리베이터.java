class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int d = storey % 10;
            int next = (storey / 10) % 10;
            if (d > 5 || (d == 5 && next >= 5)) {
                answer += 10 - d;
                storey += 10;
            }else{
                answer += d;
            }
            storey /= 10;
        }
        
        
        return answer;
    }
}