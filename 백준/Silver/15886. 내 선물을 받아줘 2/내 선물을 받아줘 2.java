import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] map;
    static boolean[] visited;
    static boolean[] finished;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = br.readLine().toCharArray();

        visited = new boolean[N];
        finished = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        System.out.println(count);
    }

    static void dfs(int x) {
        visited[x] = true;

        int next = (map[x] == 'E') ? x + 1 : x - 1;

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            count++;
        }

        finished[x] = true;
    }
}
