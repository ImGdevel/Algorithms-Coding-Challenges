import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/// 실제 알고리즘 코드를 작성해주세요 ///

class Solution {
    public int[] solution(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int n : nums){
            min = Math.min(n, min);
            max = Math.max(n, max);
        }

        return new int[]{min, max};
    }
}

///______________________________///

public class Main {

    static Solution solution = new Solution();

    public static void main(String[] args) throws IOException {
        // 입출력을 정의해주세요.
        int K = InputView.readInt();
        int[] nums = InputView.readIntArray();
        int[] answer = solution.solution(nums);
        OutputView.printArray(answer);
    }
}

// Input&Output View Utils
class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1. 정수 한 개를 입력받아 반환
    public static int readInt() throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    // 2. K개의 정수를 입력받아 배열로 반환
    public static int[] readIntArray() throws IOException {
        return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    // 3. N x M개의 정수를 입력받아 2차원 배열로 반환
    public static int[][] readIntMatrix(int n, int m) throws IOException {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = readIntArray();
        }
        return matrix;
    }

    // 4. char 형태의 입력 메서드
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

    // 5. String 형태의 입력 메서드
    public static String readString() throws IOException {
        return br.readLine().trim();
    }

    public static String[] readStringArray() throws IOException {
        return br.readLine().trim().split(" ");
    }
}

class OutputView {
    public static void print(String message) {
        System.out.println(message);
    }

    public static void printArray(int[] array) {
        for(int n : array) {
            System.out.print(n + " ");
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void printCharArray(char[] array) {
        for(char ch : array) {
            System.out.print(ch + " ");
        }
    }

    public static void printCharMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
