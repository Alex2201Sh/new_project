package by.aston.lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HashMapExample {
    /*
new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3
new int[] { 1, 1, 3, 3, 7, 2, 2, 2 }

new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3
new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 }

new int[] { 1, 1, 1, 1, 1 }, 5
new int[] { 1, 1, 1, 1, 1 }

new int[] { }, 5
new int[] { }

new int[] { 20, 37, 20, 21 }, 1
new int[] { 20, 37, 21 }
 */
    public static void main(String[] args) {
        int[] result = arrayProcessor(new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] arrayProcessor(int[] ints, int maxOccurences) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            map.put(ints[i],
                    map.getOrDefault(ints[i], 0) + 1);
            if (map.get(ints[i]) <= maxOccurences) {
                resultList.add(ints[i]);
            }
        }

        return resultList.stream()
                .mapToInt(value -> value)
                .toArray();
    }
}
