package by.aston.livecoding.algo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Algo8NotPrimeNumbers {
    public static void main(String[] args) {
        List<Integer> expected = Arrays.asList(22, 25, 27, 32, 33, 35, 52, 55, 57, 72, 75, 77);
        List<Integer> actual = Algo8NotPrimeNumbers.notPrimes(2, 222);
        System.out.println(expected);
        System.out.println(actual);
    }

    public static List<Integer> notPrimes(int a, int b) {
        return IntStream.range(a, b)
                .boxed()
                .filter(integer -> String.valueOf(integer).matches("[2357]{2,5}")) //filter by digits
                .filter(integer -> IntStream.range(1, integer)
                        .filter(value -> integer % value == 0)
                        .limit(2)
                        .count() != 1)  //filter is integer not primes
                .toList();
    }
}
