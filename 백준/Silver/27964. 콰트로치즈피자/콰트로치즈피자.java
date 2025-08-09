import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> cheeses = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String topping = sc.next();
            if (topping.endsWith("Cheese")) cheeses.add(topping); 
        }
        sc.close();
        System.out.println(cheeses.size() >= 4 ? "yummy" : "sad");
    }
}
