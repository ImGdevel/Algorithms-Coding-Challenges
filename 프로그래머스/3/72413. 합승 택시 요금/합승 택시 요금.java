import java.util.*;

class Solution {
    public int solution(int n, int start, int a, int b, int[][] fares) {
        int[][] dist = new int[n][n];

        // 초기화: 자기 자신으로의 거리는 0, 나머지는 무한대
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        // 간선 정보 초기화
        for (int[] fare : fares) {
            int u = fare[0] - 1;
            int v = fare[1] - 1;
            int w = fare[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        // 플로이드 워셜 알고리즘
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // 최적의 합승 지점 찾기
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist[start-1][i] != Integer.MAX_VALUE && dist[i][a-1] != Integer.MAX_VALUE && dist[i][b-1] != Integer.MAX_VALUE) {
                answer = Math.min(answer, dist[start-1][i] + dist[i][a-1] + dist[i][b-1]);
            }
        }

        return answer;
    }
}
