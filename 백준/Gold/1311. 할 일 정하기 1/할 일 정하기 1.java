import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/// 알고리즘 코드를 작성해주세요 /////////////////////////////////////////

import  java.util.*;


class Solution {

    public int solution(int N, int[][] tasks) {
        int[] dp = new int[1 << N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 모든 비트마스크 상태를 순회
        for (int mask = 0; mask < (1 << N); mask++) {
            int worker = Integer.bitCount(mask); // 현재까지 할당된 작업의 수 = 다음에 할당할 사람의 인덱스

            if (worker >= N) continue; // 이미 모든 작업이 할당되었다면 스킵

            // 가능한 모든 작업에 대해
            for (int j = 0; j < N; j++) {
                if ((mask & (1 << j)) != 0) continue; // 이미 할당된 작업이라면 스킵

                int nextMask = mask | (1 << j);
                dp[nextMask] = Math.min(dp[nextMask], dp[mask] + tasks[worker][j]);
            }
        }

        return dp[(1 << N) - 1]; // 모든 작업이 할당된 최종 상태의 최소 비용
    }
}



/// 입출력을 정의해주세요 ///////////////////////////////////////////////

public class Main {

    static Solution solution = new Solution();

    public static void main(String[] args) throws IOException {
        // Input
        int N = InputView.readInt();

        int[][] tasks = InputView.readIntMatrix(N, N);

        // Solution
        int ans = solution.solution(N, tasks);

        //Output
        OutputView.print(ans);
    }
}

/// [ Input&Output View 라이브러리 ] //////////////////////////////////
class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int readInt() throws IOException { return Integer.parseInt(br.readLine().trim()); }

    public static int[] readIntArray() throws IOException { return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray(); }

    public static int[][] readIntMatrix(int n, int m) throws IOException { int[][] matrix = new int[n][m]; for (int i = 0; i < n; i++) { matrix[i] = readIntArray(); } return matrix; }

    public static char readChar() throws IOException { return br.readLine().trim().charAt(0); }

    public static char[] readCharArray() throws IOException { return br.readLine().trim().toCharArray(); }

    public static char[][] readCharMatrix(int n, int m) throws IOException { char[][] matrix = new char[n][m]; for (int i = 0; i < n; i++) { matrix[i] = readCharArray(); } return matrix; }

    public static String readString() throws IOException { return br.readLine().trim(); }

    public static String[] readStringArray(int n) throws IOException { String[] array = new String[n]; for (int i = 0; i < n; i++) { array[i] = br.readLine().trim(); } return array; }
}

class OutputView {
    public static void print(String message) { System.out.println(message); }

    public static void print(int message) { System.out.println(message); }

    public static void print(long message) { System.out.println(message); }

    public static void print(int[] array) { for (int n : array) { System.out.print(n + " "); } }

    public static void print(int[][] matrix) { for (int[] row : matrix) { for (int n : row) { System.out.print(n + " "); } System.out.println(); } }

    public static void print(char[] array) { for (char ch : array) { System.out.print(ch + " "); } }

    public static void print(char[][] matrix) { for (char[] row : matrix) { for (char ch : row) { System.out.print(ch + " "); } System.out.println(); } }

    public static void print(String[] array) { for (String str : array) { System.out.println(str); } }

    public static void print(List<String> array) { for (String str : array) { System.out.println(str); } }
}
