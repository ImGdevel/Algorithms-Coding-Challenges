import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp[i]: 숫자 i를 표현하기 위한 최소 제곱수 개수
        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 최악의 경우 (1^2을 i번 더한 경우)

            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
