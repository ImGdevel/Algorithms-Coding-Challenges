import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            Integer[] A = new Integer[10];
            for (int i = 0; i < 10; i++) {
                A[i] = sc.nextInt();
            }

            Arrays.sort(A, Collections.reverseOrder());
            System.out.println(A[2]);
        }
    }
}
