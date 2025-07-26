import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Character, Integer> colorCount = new HashMap<>();
        Map<Integer, Integer> numberCount = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        char[] colors = new char[5];

        for (int i = 0; i < 5; i++) {
            String color = sc.next();
            int number = sc.nextInt();
            colors[i] = color.charAt(0);
            colorCount.put(colors[i], colorCount.getOrDefault(colors[i], 0) + 1);
            numberCount.put(number, numberCount.getOrDefault(number, 0) + 1);
            numbers.add(number);
        }

        Collections.sort(numbers);

        boolean isFlush = colorCount.size() == 1;
        boolean isStraight = true;
        for (int i = 1; i < 5; i++) {
            if (numbers.get(i) != numbers.get(i - 1) + 1) {
                isStraight = false;
                break;
            }
        }

        int maxNumber = numbers.get(4);

        // 같은 숫자 개수에 따른 처리
        List<Map.Entry<Integer, Integer>> countList = new ArrayList<>(numberCount.entrySet());
        countList.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) return b.getKey() - a.getKey(); // 큰 숫자가 먼저
            return b.getValue() - a.getValue(); // 더 많이 나온 숫자가 먼저
        });

        int result = 0;

        if (isFlush && isStraight) {
            result = maxNumber + 900;
        } else if (countList.get(0).getValue() == 4) {
            result = countList.get(0).getKey() + 800;
        } else if (countList.get(0).getValue() == 3 && countList.get(1).getValue() == 2) {
            result = countList.get(0).getKey() * 10 + countList.get(1).getKey() + 700;
        } else if (isFlush) {
            result = maxNumber + 600;
        } else if (isStraight) {
            result = maxNumber + 500;
        } else if (countList.get(0).getValue() == 3) {
            result = countList.get(0).getKey() + 400;
        } else if (countList.get(0).getValue() == 2 && countList.get(1).getValue() == 2) {
            int big = Math.max(countList.get(0).getKey(), countList.get(1).getKey());
            int small = Math.min(countList.get(0).getKey(), countList.get(1).getKey());
            result = big * 10 + small + 300;
        } else if (countList.get(0).getValue() == 2) {
            result = countList.get(0).getKey() + 200;
        } else {
            result = maxNumber + 100;
        }

        System.out.println(result);
    }
}
