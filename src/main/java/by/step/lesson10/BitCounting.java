package by.step.lesson10;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/526571aae218b8ee490006f4/train/java
 */
public class BitCounting {
    public static int countBits(int n) {
        //        return Math.toIntExact(Arrays.stream(Integer.toBinaryString(n).split("")).filter("1"::equals).count());
        return (int) Arrays.stream(Integer.toBinaryString(n).split("")).filter("1"::equals).count();
    }

}
