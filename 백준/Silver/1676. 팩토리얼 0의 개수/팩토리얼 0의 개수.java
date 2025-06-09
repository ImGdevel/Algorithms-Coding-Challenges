import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger factorial = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String str = factorial.toString();
        int count = 0;

        // 문자열 뒤에서부터 0이 아닌 숫자 만날 때까지 카운트
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0') count++;
            else break;
        }

        System.out.println(count);
    }
}
