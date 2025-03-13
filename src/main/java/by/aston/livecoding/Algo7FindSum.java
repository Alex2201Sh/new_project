package by.aston.livecoding;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Algo7FindSum {
    //дано
    //int[]array = new int[]{5,7,2,3};
    //int target = 9;
    //найти пару чисел из array, которые в сумме дают target

    public static void main(String[] args) {
        int[] array = new int[]{5, 5, 5, 5, 5, -5, 4, 5, 5, 5, 1, 1, 2, 3, 10};
        int target = 5;
        System.out.println(getPair(array, target));
    }

    public static String getPair(int[] array, int target) {
        return IntStream.range(0, array.length)
                .boxed()
                .map(i -> {
                    int[] ints = new int[array.length - i - 1];
                    System.arraycopy(array, i + 1, ints, 0, array.length - i - 1);
                    LinkedHashMap<Integer, Integer> collect = Arrays.stream(ints)
                            .boxed()
                            .collect(Collectors.toMap(Integer::valueOf, Integer::valueOf, (integer1, integer2) -> integer1,
                                    LinkedHashMap::new));
//                    System.out.println(collect + " " + array[i] + " " + array.length);
                    if (collect.containsKey(target - array[i])) {
                        return array[i] + " " + (target - array[i]);
                    }
                    return "";
                })
                .filter(s -> !s.isBlank())
                .toList().toString();
//                .findFirst()
//                .orElseGet(() -> "числа не найдены");
    }
}
