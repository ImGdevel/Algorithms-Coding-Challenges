import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.spec.ECField;
import java.util.Arrays;

/// 알고리즘 코드를 작성해주세요 /////////////////////////////////////////

import  java.util.*;

class Solution {

    class Edge{
        int src;
        int dest;
        int weight;


        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    public boolean DFS(List<Edge>[] g, Stack<Integer> root, int[] dist , int node, int dest){
        if(node == dest){
            root.push(node);
            return true;
        }

        for(Edge next : g[node]){

            if( next.weight <= dist[next.dest] && DFS(g, root, dist, next.dest, dest)){
                root.push(node);
                return true;
            }
        }

        return false;
    }

    public void solution(int V, int[][] edges, int A, int B) {

        List<Edge>[] graph = new List[V + 1];
        for(int i = 0 ;i<=V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++){
            int s = edges[i][0];
            int e = edges[i][1];
            int w = edges[i][2];
            graph[s].add(new Edge(s,e,w));
        }

        Queue<Edge> pq = new PriorityQueue<>((a,b)-> a.weight - b.weight);
        pq.offer(new Edge(A, A, 0));
        int[] dist = new int[V + 1];
        int[] dp = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[A] = 0;

        List<Edge>[] g = new List[V + 1];
        for(int i = 0 ;i<=V; i++){
            g[i] = new ArrayList<>();
        }

        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            int v = edge.dest;

            if(edge.weight > dist[v]) continue;;

            for(Edge next : graph[v]){
                int u = next.dest;
                int newDist = dist[v] + next.weight;

                if(newDist < dist[u]) {
                    dist[u] = newDist;
                    pq.offer(new Edge(v, u, newDist));
                    g[v].add(new Edge(v, u, newDist));
                }
            }
        }

        System.out.println(dist[B]);
        Stack<Integer> root = new Stack<>();
        DFS(g, root, dist, A, B);

        System.out.println(root.size());
        while(!root.isEmpty()) {
            System.out.print(root.pop() + " ");
        }
    }

}


/// 입출력을 정의해주세요 ///////////////////////////////////////////////

public class Main {

    static Solution solution = new Solution();

    public static void main(String[] args) throws IOException {
        // Input
        int V = InputView.readInt();
        int T = InputView.readInt();

        int edges[][] = InputView.readIntMatrix(T,3);

        int[] n = InputView.readIntArray();

        solution.solution(V,edges,n[0], n[1]);

    }
}

/// [ Input&Output View 라이브러리 ] //////////////////////////////////
class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int readInt() throws IOException { return Integer.parseInt(br.readLine().trim()); }

    public static int[] readIntArray() throws IOException { return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray(); }

    public static int[][] readIntMatrix(int n, int m) throws IOException { int[][] matrix = new int[n][m]; for (int i = 0; i < n; i++) { matrix[i] = readIntArray(); } return matrix; }

    public static char readChar() throws IOException { return br.readLine().trim().charAt(0); }

    public static char[] readCharArray() throws IOException { return br.readLine().trim().toCharArray(); }

    public static char[][] readCharMatrix(int n, int m) throws IOException { char[][] matrix = new char[n][m]; for (int i = 0; i < n; i++) { matrix[i] = readCharArray(); } return matrix; }

    public static String readString() throws IOException { return br.readLine().trim(); }

    public static String[] readStringArray(int n) throws IOException { String[] array = new String[n]; for (int i = 0; i < n; i++) { array[i] = br.readLine().trim(); } return array; }
}

class OutputView {
    public static void print(String message) { System.out.println(message); }

    public static void print(int message) { System.out.println(message); }

    public static void print(long message) { System.out.println(message); }

    public static void print(int[] array) { for (int n : array) { System.out.print(n + " "); } }

    public static void print(int[][] matrix) { for (int[] row : matrix) { for (int n : row) { System.out.print(n + " "); } System.out.println(); } }

    public static void print(char[] array) { for (char ch : array) { System.out.print(ch + " "); } }

    public static void print(char[][] matrix) { for (char[] row : matrix) { for (char ch : row) { System.out.print(ch + " "); } System.out.println(); } }

    public static void print(String[] array) { for (String str : array) { System.out.println(str); } }

    public static void print(List<String> array) { for (String str : array) { System.out.println(str); } }
}
