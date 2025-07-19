import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] count = new int[2][6];

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            int Y = sc.nextInt();
            count[S][Y - 1]++; 
        }

        int roomCount = 0;

        for (int gender = 0; gender <= 1; gender++) {
            for (int grade = 0; grade < 6; grade++) {
                int students = count[gender][grade];
                if (students > 0) {
                    roomCount += (students + K - 1) / K;
                }
            }
        }

        System.out.println(roomCount);
    }
}
