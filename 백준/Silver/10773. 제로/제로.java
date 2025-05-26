import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();  // 입력 개수
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();  // 마지막 수 제거
                }
            } else {
                stack.push(num);  // 수 추가
            }
        }

        int sum = 0;
        for (int n : stack) {
            sum += n;
        }

        System.out.println(sum);  // 최종 합 출력
    }
}
