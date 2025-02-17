import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        
        int answer = 0;
        int N = sticker.length;
        int[] op1 = new int[N]; // 첫번째 스티커를 선택하는 경우의 수
        int[] op2 = new int[N]; // 첫번쨰 스티커를 선택하지 않는 경우의 수
        op1[0] = sticker[0]; op1[1] = sticker[0];
        op2[1] = sticker[1];
        // 첫 선택
        for(int i=2; i<N; i++){
            op2[i] = Math.max(op2[i-1], op2[i-2] + sticker[i]);
            if(i == N-1) {
                sticker[i] = 0; // 선택 막기
            }
            op1[i] = Math.max(op1[i-1], op1[i-2] + sticker[i]);
        }
        
        return Math.max(op1[N-1], op2[N-1]);
    }
}