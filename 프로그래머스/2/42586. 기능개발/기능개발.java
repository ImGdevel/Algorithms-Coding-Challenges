import java.util.*;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> daysQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            daysQueue.offer(days);
        }

        while (!daysQueue.isEmpty()) {
            int first = daysQueue.poll(); 
            int count = 1;

            while (!daysQueue.isEmpty() && daysQueue.peek() <= first) {
                daysQueue.poll();
                count++;
            }

            answerList.add(count);
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
