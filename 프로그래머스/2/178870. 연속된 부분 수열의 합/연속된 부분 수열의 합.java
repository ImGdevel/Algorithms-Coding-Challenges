class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int right, left;
        
        // 누적합
        int N = sequence.length;
        int[] prefixSum = new int[N + 1];
        left = N-1; right = N;
        
        for(int i=1; i<=N ;i++){
            prefixSum[i] = sequence[i-1] + prefixSum[i-1];
        }
        
        int minLength = Integer.MAX_VALUE;
        while(left >= 0 && right >= 0){
            int sum = prefixSum[right] - prefixSum[left];
            //System.out.println(sum +  "> " + left + " " + (right-1));
            if(sum == k){
                if((right - left) <= minLength){
                    //System.out.println( "answer: " + left + " " +  (right-1));
                    answer[0] = left;
                    answer[1] = right-1;
                    minLength = (right - left);
                }
                left--;
                right--;
            }else if(sum < k){
                left--;
            }else{
                right--;
            }
            
        }
        
        return answer;
    }
}