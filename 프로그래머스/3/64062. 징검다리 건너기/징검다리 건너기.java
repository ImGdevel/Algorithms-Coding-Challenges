class Solution {
    
    public boolean check(int[] stones, int target, int k){
        
        int lastZeroCount = 0;
        boolean isZero = false;
        for(int i =0; i< stones.length; i++){
            int d = stones[i] - (target - 1);
            // 현재 위치가
            if(d <= 0){
                //처음으로 점프하기
                lastZeroCount++;
                if(lastZeroCount >= k){
                    return false;
                }
            }else{
                lastZeroCount = 0;
            }
        }
        
        return true;
    }
    
    public int solution(int[] stones, int k) {
        int maxStone = 0;
        for(int n : stones){
             maxStone = Math.max(n, maxStone);
        }
        int answer = 1;
        int left, right;
        left = 0; right = maxStone;
        while(left <= right){
            int mid = (left + right) / 2;
            if(check(stones, mid, k)){
                left = mid + 1;
                answer = mid;
            }else{
                right = mid - 1;
            }
        }
        return answer;
    }
}