import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : weights) {
            int n = num * 12; // 계산 쉽게
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Integer num : map.keySet()) {
            int count = map.get(num);

            // 1:1
            if (count > 1) {
                answer += (long) count * (count - 1) / 2;
            }

            // 1:2 
            if (map.containsKey((num * 2) / 1)) {
                answer += (long) count * map.get((num * 2) / 1);
            }

            // 2:3 
            if (map.containsKey((num * 3) / 2)) {
                answer += (long) count * map.get((num * 3) / 2);
            }

            // 3:4 
            if (map.containsKey((num * 4) / 3)) {
                answer += (long) count * map.get((num * 4) / 3);
            }
        }

        return answer;
    }
}