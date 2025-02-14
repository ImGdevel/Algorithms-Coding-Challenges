import java.util.*;

class Solution {
    
    boolean[] primeSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
    
    void DFS(String str, String concatStr, boolean[] check, Set<Integer> numbers) {
        if (!concatStr.isEmpty()) {
            numbers.add(Integer.parseInt(concatStr));
        }

        for (int i = 0; i < str.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                DFS(str, concatStr + str.charAt(i), check, numbers);
                check[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        boolean[] isPrime = primeSieve(9999999);
        Set<Integer> concatNumbers = new HashSet<>();
        boolean[] check = new boolean[numbers.length()];

        DFS(numbers, "", check, concatNumbers);

        int answer = 0;
        for (int number : concatNumbers) {
            if (isPrime[number]) {
                answer++;
            }
        }

        return answer;
        
    }
}
