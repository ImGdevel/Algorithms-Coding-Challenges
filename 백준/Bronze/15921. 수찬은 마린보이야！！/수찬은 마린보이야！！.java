import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N == 0) {
            System.out.println("divide by zero");
            return;
        }

        int[] records = new int[N];
        double sum = 0;

        for (int i = 0; i < N; i++) {
            records[i] = sc.nextInt();
            sum += records[i];
        }

        double expectedValue = sum / N;

        if (expectedValue == 0) {
            System.out.println("divide by zero");
            return;
        }

        double result = sum / expectedValue / N;

        System.out.printf("%.2f\n", result);
    }
}
