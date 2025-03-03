import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n1 = InputView.readInt();
        int n2 = InputView.readInt();
        OutputView.print(String.valueOf(n1+n2));
    }
}

class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    // 1. 정수 한 개를 입력받아 반환
    public static int readInt() {
        return scanner.nextInt();
    }

    // 2. K개의 정수를 입력받아 배열로 반환
    public static int[] readIntArray() {
        String[] input = scanner.nextLine().trim().split(" ");
        return Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
    }

    // 3. N x M개의 정수를 입력받아 2차원 배열로 반환
    public static int[][] readIntMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = readIntArray();
        }
        return matrix;
    }

    // 4. char 형태의 입력 메서드
    public static char readChar() {
        return scanner.next().charAt(0);
    }

    public static char[] readCharArray() {
        return scanner.nextLine().trim().toCharArray();
    }

    public static char[][] readCharMatrix(int n, int m) {
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = readCharArray();
        }
        return matrix;
    }

    // 5. String 형태의 입력 메서드
    public static String readString() {
        return scanner.nextLine().trim();
    }

    public static String[] readStringArray() {
        return scanner.nextLine().trim().split(" ");
    }
}

class OutputView {
    public static void print(String message) {
        System.out.println(message);
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void printCharArray(char[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printCharMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
