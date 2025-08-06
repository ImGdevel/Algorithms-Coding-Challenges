import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int minPackagePrice = Integer.MAX_VALUE;
        int minSinglePrice = Integer.MAX_VALUE; 

        for (int i = 0; i < M; i++) {
            int packagePrice = sc.nextInt();
            int singlePrice = sc.nextInt();
            minPackagePrice = Math.min(minPackagePrice, packagePrice);
            minSinglePrice = Math.min(minSinglePrice, singlePrice);
        }

        int costPackageOnly = ((N + 5) / 6) * minPackagePrice;

        int costSingleOnly = N * minSinglePrice;

        int packageCount = N / 6;
        int remainingSingles = N % 6;
        int costMix = packageCount * minPackagePrice + remainingSingles * minSinglePrice;

        costMix = Math.min(costMix, (packageCount + 1) * minPackagePrice);

        int result = Math.min(costPackageOnly, Math.min(costSingleOnly, costMix));
        System.out.println(result);
    }
}
