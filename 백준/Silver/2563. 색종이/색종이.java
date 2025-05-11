import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/// 알고리즘 코드를 작성해주세요 /////////////////////////////////////////

import  java.util.*;


class AlgSolution {

    public int solution(int[][] nums) {

        boolean[][] board = new boolean[100][100];
        int N = nums.length;
        for(int[] pos : nums){
            int x = pos[0];
            int y = pos[1];
            for(int i=x; i<x+10; i++) {
                for (int j = y; j < y + 10; j++) {
                    board[i][j] = true;
                }
            }
        }

        int count = 0;
        for(int i=0; i<100; i++) {
            for (int j = 0; j < 100; j++) {
                if(board[i][j]){
                    count++;
                }
            }
        }

        return count;
    }
}

/// 입출력을 정의해주세요 ///////////////////////////////////////////////

public class Main {

    static AlgSolution solution = new AlgSolution();

    public static void main(String[] args) throws IOException {
        // Input
        int num = InputView.readInt();
        int[][] nums = InputView.readIntMatrix(num, 2);

        // Output
        OutputView.print(
                // Solution //
                solution.solution(nums)
        );
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
