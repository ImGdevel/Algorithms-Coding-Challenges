import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        String first = fs.next();
        if (first == null) return;

        int N = Integer.parseInt(first);
        int R = fs.nextInt();

        boolean[] returned = new boolean[N + 1];

        for (int i = 0; i < R; i++) {
            int id = fs.nextInt();
            if (1 <= id && id <= N) returned[id] = true;
        }

        StringBuilder sb = new StringBuilder();
        boolean anyMissing = false;

        for (int i = 1; i <= N; i++) {
            if (!returned[i]) {
                sb.append(i).append(' ');
                anyMissing = true;
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        if (anyMissing) out.println(sb.toString());
        else out.println("*");
        out.flush();
    }
}
