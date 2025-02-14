import java.util.*;

class Solution {
    public boolean check(int n, int[] times, long target) {
        long num = n;
        for (int time : times) {
            num -= target / time;
            if (num <= 0) return true;
        }
        return false;
    }

    public long solution(int n, int[] times) {
        long left = 1;
        long maxTime = Arrays.stream(times).max().getAsInt();
        long right = maxTime * (long) n;
        long answer = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(n, times, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}

