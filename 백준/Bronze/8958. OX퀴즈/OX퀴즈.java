import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            String line = sc.nextLine();
            int score = 0;
            int cnt = 0;

            for (char c : line.toCharArray()) {
                if (c == 'O') {
                    cnt++;
                    score += cnt;
                } else {
                    cnt = 0;
                }
            }

            System.out.println(score);
        }

        sc.close();
    }
}
