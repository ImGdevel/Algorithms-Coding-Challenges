import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;

        for (int i = Math.max(1, N - 54); i < N; i++) {
            int sum = i + digitSum(i);
            if (sum == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
