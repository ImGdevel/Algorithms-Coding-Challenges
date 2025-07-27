import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int totalScore = 0;
        int currentStreak = 0; 

        for (int i = 0; i < N; i++) {
            int result = sc.nextInt();

            if (result == 1) {
                currentStreak++; 
                totalScore += currentStreak; 
            } else {
                currentStreak = 0; 
            }
        }

        System.out.println(totalScore);
    }
}
