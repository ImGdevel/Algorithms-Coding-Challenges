import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] height = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            height[i] = sc.nextLong();
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int visible = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;

                boolean canSee = true;

                int left = Math.min(i, j);
                int right = Math.max(i, j);

                for (int k = left + 1; k < right; k++) {
                    double yOnLine = height[i] + (double)(height[j] - height[i]) * (k - i) / (j - i);

                    if (height[k] >= yOnLine) {
                        canSee = false;
                        break;
                    }
                }

                if (canSee) visible++;
            }
            answer = Math.max(answer, visible);
        }

        System.out.println(answer);
    }
}
