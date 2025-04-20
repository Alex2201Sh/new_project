package by.aston.livecoding.algo;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Algo9FindUnique {
    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1})); // => 2
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0}));  // => 0.55
    }

    public static double findUniq(double arr[]) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(doubleLongEntry -> doubleLongEntry.getValue() == 1)
                .findFirst()
                .get()
                .getKey();
    }
}
