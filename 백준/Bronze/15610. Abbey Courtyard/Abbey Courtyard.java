import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();

        double length = 4 * Math.sqrt(a);

        System.out.printf("%.10f\n", length);
    }
}
