import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int totalRemainder = 0;

        for (int i = 0; i < N; i++) {
            int students = sc.nextInt();
            int apples = sc.nextInt();

            totalRemainder += apples % students;
        }

        System.out.println(totalRemainder);
    }
}
