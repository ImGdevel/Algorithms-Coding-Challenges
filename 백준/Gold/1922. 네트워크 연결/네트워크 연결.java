import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/// 알고리즘 코드를 작성해주세요 /////////////////////////////////////////

import  java.util.*;

class Solution {

    class Edge{
        int from;
        int to;
        int weight;

        public Edge(int f, int t, int w){
            from = f; to = t; weight = w;
        }

    }

    int find(int[] parent, int n){
        if(parent[n] != n){
            parent[n] = find(parent, parent[n]);
        }
        return parent[n];
    }

    void union(int[] parent, int[] rank, int a, int b){
        a = find(parent, a);
        b = find(parent, b);
        if(a != b){
            if(rank[a] < rank[b]){
                parent[b] = a;
            }else if(rank[a] > rank[b]){
                parent[a] = b;
            }else{
                parent[a] = b;
                rank[b]++;
            }
        }
    }



    public int solution(int V, int[][] edges) {
        int count = 0;

        int[] rank = new int[V];
        int[] parent = new int[V];
        for(int i=0; i<V; i++){
            parent[i] = i;
        }
        int total = 0;
        Arrays.sort(edges, (a,b)->a[2]-b[2]);

        for(int[] edge: edges){
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            int w = edge[2];
            a = find(parent, a);
            b = find(parent, b);
            if(a != b){
                total += w;
                union(parent, rank, a, b);
            }
        }

        return total;
    }
}


/// 입출력을 정의해주세요 ///////////////////////////////////////////////

public class Main {

    static Solution solution = new Solution();

    public static void main(String[] args) throws IOException {
        // Input
        int N = InputView.readInt();

        int E = InputView.readInt();

        int[][] edges = InputView.readIntMatrix(E,3);

        // Solution
        int ans = solution.solution(N, edges);

        //Output
        OutputView.print(ans);
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
