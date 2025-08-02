import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] votes = new int[N];

        for (int i = 0; i < N; i++) {
            votes[i] = sc.nextInt();
        }

        int maxVotes = votes[0];
        boolean carlosWins = true; 

        for (int i = 1; i < N; i++) {
            if (votes[i] > maxVotes) {
                carlosWins = false;
                maxVotes = votes[i];
            }
        }

        System.out.println(carlosWins ? "S" : "N");
    }
}
