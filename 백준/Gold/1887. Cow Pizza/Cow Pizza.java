import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int N = sc.nextInt();

        List<Integer> constraints = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int Z = sc.nextInt();
            int mask = 0;
            for (int j = 0; j < Z; j++) {
                int topping = sc.nextInt();
                mask |= 1 << (topping - 1);
            }
            constraints.add(mask);
        }

        int total = 0;

        int max = 1 << T;
        for (int pizza = 0; pizza < max; pizza++) {
            boolean isValid = true;
            for (int c : constraints) {
                if ((pizza & c) == c) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) total++;
        }

        System.out.println(total);
    }
}
