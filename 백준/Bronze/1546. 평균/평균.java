import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 과목 수 입력
        double[] scores = new double[n];

        double maxScore = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
            if (scores[i] > maxScore) {
                maxScore = scores[i]; // 최댓값 찾기
            }
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (scores[i] / maxScore) * 100; // 점수 조작 후 합산
        }

        System.out.println(sum / n); // 새로운 평균 출력
    }
}
