import java.util.Scanner;

public class Main {
    static int N;
    static int[][] cost;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cost = new int[N][N];
        dp = new int[1 << N]; // dp[mask] = 최소 비용, mask는 비트마스크 (일의 할당 상태)

        // 비용 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        // dp 배열 초기화 (최대값으로 설정)
        for (int i = 0; i < (1 << N); i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0; // 초기 상태 (아무 일도 배정되지 않은 상태)

        // 모든 상태를 순회
        for (int mask = 0; mask < (1 << N); mask++) {
            int worker = Integer.bitCount(mask); // 현재까지 할당된 사람의 수

            if (worker >= N) continue; // 모든 사람에게 일이 할당된 경우 스킵

            // 현재 사람이 가능한 모든 일에 대해 시도
            for (int job = 0; job < N; job++) {
                // 해당 일이 아직 할당되지 않았다면
                if ((mask & (1 << job)) == 0) {
                    int nextMask = mask | (1 << job);
                    dp[nextMask] = Math.min(dp[nextMask], dp[mask] + cost[worker][job]);
                }
            }
        }

        // 모든 일이 할당된 최종 상태의 최소 비용 출력
        System.out.println(dp[(1 << N) - 1]);
    }
}
