import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double p = Double.parseDouble(st.nextToken());
        double q = Double.parseDouble(st.nextToken());
        double r = Double.parseDouble(st.nextToken());

        if (Math.abs(r - p) > 1e-9) {
            System.out.println(0); 
            return;
        }
        double area = 2.0 * p * (p + q);

        System.out.printf(java.util.Locale.US, "%.4f%n", area);
    }
}
