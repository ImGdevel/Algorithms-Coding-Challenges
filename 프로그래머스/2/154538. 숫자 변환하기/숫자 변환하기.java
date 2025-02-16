import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        int[] dp = new int[y + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        dp[x] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int next : new int[]{cur * 3, cur * 2, cur + n}) {
                if (next > y || dp[next] != 0) continue;
                dp[next] = dp[cur] + 1;
                queue.add(next);
            }
        }

        return dp[y] == 0 ? -1 : dp[y] - 1;
    }
}
