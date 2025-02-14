// 해설 : 누적합 + 슬라이딩 윈도우
// 시간 0.8초
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for(int i=1; i <= n; i++){
            prefixSum[i] = i + prefixSum[i-1];
        }

        int left = 0, right = 1;
        while(right <= n){
            int sum = prefixSum[right] - prefixSum[left];
            if(sum == n){
                right++;
                answer++;
            } else if(sum < n){
                right++;
            } else{
                left++;
            }
        }
        return answer;
    }
}