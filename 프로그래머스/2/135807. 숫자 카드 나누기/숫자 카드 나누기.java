import java.util.*;

class Solution {
    
    // 최대 공약수
    int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        // arrayA 철수 로 나눌수 있지만 영희로는 나눌수 없는 a
        // arrayB 영희 로 나눌수 있지만 철수로 나눌수 없는 b
        
        
        // A수의 최대 공약수를 구함, 
        // 최대 공약수의 공약수들을 구함
        int gcdA = arrayA[0];
        for(int i= 1; i < arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        for(int i= 1; i < arrayB.length; i++){
            gcdB = gcd(gcdB, arrayB[i]);
        }
        System.out.println(gcdA + " " + gcdB);
        
        
        // 철수 판별
        int A = 0, B = 0;
        if(gcdA != 1){
            A = gcdA;
            for(int i= 0; i < arrayB.length; i++){
                if(arrayB[i] % gcdA == 0){
                    A = 0;
                    break;
                }
            }
        }
        
        if(gcdB != 1){
            B = gcdB;
            for(int i= 0; i < arrayA.length; i++){
                if(arrayA[i] % gcdB == 0){
                    B = 0;
                    break;
                }
            }
        }
        
        return Math.max(A, B);
    }

}