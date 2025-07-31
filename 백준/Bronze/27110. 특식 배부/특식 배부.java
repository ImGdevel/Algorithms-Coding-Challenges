import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); 
        int A = sc.nextInt();    
        int B = sc.nextInt();     
        int C = sc.nextInt();    

        int result = Math.min(A, N) + Math.min(B, N) + Math.min(C, N);
        System.out.println(result);
    }
}
