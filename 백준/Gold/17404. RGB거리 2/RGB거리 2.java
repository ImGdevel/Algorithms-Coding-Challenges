import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1000 * 1000;
    static int[][] cost;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); 
            cost[i][1] = Integer.parseInt(st.nextToken()); 
            cost[i][2] = Integer.parseInt(st.nextToken()); 
        }

        int result = INF;

        for (int first = 0; first < 3; first++) {
            int[][] dp = new int[N][3];

            for (int i = 0; i < 3; i++) {
                if (i == first) dp[0][i] = cost[0][i];
                else dp[0][i] = INF;
            }

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
            }

            for (int last = 0; last < 3; last++) {
                if (last != first) {
                    result = Math.min(result, dp[N - 1][last]);
                }
            }
        }

        System.out.println(result);
    }
}
