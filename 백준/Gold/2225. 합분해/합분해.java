import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.spec.ECField;
import java.util.Arrays;

/// 알고리즘 코드를 작성해주세요 /////////////////////////////////////////

import  java.util.*;

class Solution {

    public long solution(int N, int K) {
        long[] dp = new long[N+1];
        long MOD = 1000000000;
        Arrays.fill(dp, 1);

        for(int x=2; x<=K; x++){
            for(int i = 1; i<= N; i++){
                dp[i] = (dp[i] + dp[i-1]) % 1000000000;
            }
        }

        //System.out.println(Arrays.toString(dp));

        return dp[N];
    }
}


/// 입출력을 정의해주세요 ///////////////////////////////////////////////

public class Main {

    static Solution solution = new Solution();

    public static void main(String[] args) throws IOException {
        // Input
        int[] N = InputView.readIntArray();

        // Solution
        long ans = solution.solution(N[0], N[1]);

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
