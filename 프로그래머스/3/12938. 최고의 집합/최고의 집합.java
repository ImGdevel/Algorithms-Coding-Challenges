class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};
        
        int[] answer = new int[n];
        int base = s / n;
        int mod = s % n;
        for(int i= n-1; i >= 0; i--){
            answer[i] = base + ((mod-- > 0)? 1 : 0);   
        }
        return answer;
    }
}