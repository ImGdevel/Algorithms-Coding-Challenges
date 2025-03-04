import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/// 알고리즘 코드를 작성해주세요 /////////////////////////////////////////

import  java.util.*;

class Solution {


    public long solution(int N) {

        long[][] dp = new long[N][2];
        dp[0][0] = 0; dp[0][1] = 1;

        for(int i=1; i<N; i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        return dp[N-1][0] + dp[N-1][1];
    }
}


/// 입출력을 정의해주세요 ///////////////////////////////////////////////

public class Main {

    static Solution solution = new Solution();

    public static void main(String[] args) throws IOException {
        // Input
        int N = InputView.readInt();

        //Solution
        long answer = solution.solution(N);

        // Output
        OutputView.print(answer);
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

    public static void printArray(int[] array) { for (int n : array) { System.out.print(n + " "); } }

    public static void printMatrix(int[][] matrix) { for (int[] row : matrix) { for (int n : row) { System.out.print(n + " "); } System.out.println(); } }

    public static void printCharArray(char[] array) { for (char ch : array) { System.out.print(ch + " "); } }

    public static void printCharMatrix(char[][] matrix) { for (char[] row : matrix) { for (char ch : row) { System.out.print(ch + " "); } System.out.println(); } }

    public static void printStringArray(String[] array) { for (String str : array) { System.out.println(str); } }

    public static void printStringArray(List<String> array) { for (String str : array) { System.out.println(str); } }
}
