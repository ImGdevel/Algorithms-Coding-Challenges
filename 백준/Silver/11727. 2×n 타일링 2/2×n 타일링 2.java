import com.sun.jdi.connect.AttachingConnector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/// 알고리즘 코드를 작성해주세요 /////////////////////////////////////////

import  java.util.*;

class Solution {
    public int solution(int N) {
        
        if(N == 1){
            return 1;
        }
        
        int answer = 0;
        int MOD = 10007;
        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 3;
        for(int i = 3; i<=N; i++){
            dp[i] = (dp[i-1] + dp[i-2] * 2) % MOD;
        }
        
        return dp[N];
    }
}



///////////////////////////////////////////////////////////////////

public class Main {

    static Solution solution = new Solution();

    public static void main(String[] args) throws IOException {
        // Input
        int N = InputView.readInt();

        // Solution
        int answer = solution.solution(N);

        // Output
        OutputView.print(answer);
    }
}

// Input&Output View Utils
class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int readInt() throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] readIntArray() throws IOException {
        return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] readIntMatrix(int n, int m) throws IOException {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = readIntArray();
        }
        return matrix;
    }

    public static char readChar() throws IOException {
        return br.readLine().trim().charAt(0);
    }

    public static char[] readCharArray() throws IOException {
        return br.readLine().trim().toCharArray();
    }

    public static char[][] readCharMatrix(int n, int m) throws IOException {
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = readCharArray();
        }
        return matrix;
    }

    public static String readString() throws IOException {
        return br.readLine().trim();
    }

    public static String[] readStringArray(int n) throws IOException {
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = br.readLine().trim();
        }
        return array;
    }
}

class OutputView {
    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(int message) {
        System.out.println(message);
    }

    public static void printArray(int[] array) {
        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void printCharArray(char[] array) {
        for (char ch : array) {
            System.out.print(ch + " ");
        }
    }

    public static void printCharMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void printStringArray(String[] array) {
        for (String str : array) {
            System.out.println(str);
        }
    }

    public static void printStringArray(List<String> array) {
        for (String str : array) {
            System.out.println(str);
        }
    }
}