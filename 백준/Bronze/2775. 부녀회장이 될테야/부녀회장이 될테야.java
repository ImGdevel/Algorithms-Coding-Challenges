import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        while (T-- > 0) {
            int k = sc.nextInt(); // 층 수
            int n = sc.nextInt(); // 호 수

            int[][] apt = new int[k + 1][n + 1];

            // 0층 세팅: i호에 i명 거주
            for (int i = 1; i <= n; i++) {
                apt[0][i] = i;
            }

            // 1층부터 k층까지 채우기
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
                }
            }

            System.out.println(apt[k][n]);
        }

        sc.close();
    }
}
