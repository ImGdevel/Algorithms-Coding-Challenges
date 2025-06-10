import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 설탕 무게 입력

        int count = 0;
        while (N >= 0) {
            if (N % 5 == 0) { // 5로 나눠떨어지는 경우
                count += N / 5;
                System.out.println(count);
                return;
            }
            N -= 3; // 5로 안나눠지면 3kg 봉지 하나 사용
            count++;
        }

        // 정확히 나눌 수 없는 경우
        System.out.println(-1);
    }
}
