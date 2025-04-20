package by.aston.livecoding.algo;

import java.util.Map;
import java.util.stream.IntStream;

public class Algo8SumOfIntegers {
    public static void main(String[] args) {
        System.out.println(add(23, 17));
    }

    public static int add(int x, int y) {
        StringBuilder sum = new StringBuilder();
        final int[] rest = {0};
        String strX = String.valueOf(x);
        String strY = String.valueOf(y);
        StringBuilder bigger, lower;
        if (strX.length() > strY.length()) {
            bigger = new StringBuilder(Integer.toBinaryString(x)).reverse();
            lower = new StringBuilder(Integer.toBinaryString(y)).reverse();
        } else {
            bigger = new StringBuilder(Integer.toBinaryString(y)).reverse();
            lower = new StringBuilder(Integer.toBinaryString(x)).reverse();
        }

        int bound = bigger.length();
        for (int i = 0; i < bound; i= Math.incrementExact(i)) {
            int c1 = Character.getNumericValue(bigger.charAt(i));
            int c2 = 0;
            if (i < lower.length()) {
                c2 = Character.getNumericValue(lower.charAt(i));
            }
            if (c1 == 0 && c2 == 0) {
                sum.append(rest[0]);
                rest[0] = 0;
            } else if ((c1 == 1 && c2 == 0) || (c1 == 0 && c2 == 1)) {
                if (rest[0] == 0) {
                    sum.append("1");
                } else {
                    sum.append("0");
                    rest[0] = 1;
                }
            } else if (c1 == 1 && c2 == 1) {
                sum.append(rest[0]);
                rest[0] = 1;
            }
        }
        if (rest[0] == 1) {
            sum.append("1");
        }


        int result = (int) Long.parseLong(sum.reverse().toString(), 2);
        return result;
    }
}
