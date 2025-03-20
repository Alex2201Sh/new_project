package by.aston.livecoding.algo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Algo2Circle {
    /*
    https://www.codewars.com/kata/59c804d923dacc6c41000004

    Print the circle with given radius
    000
    000
    000

     000
    00000
    00000
    00000
     000
     
     000010000
    00000200000
  000000030000000
  000000040000000
 00000000500000000
0000000006000000000
0000000007000000000
0000000008000000000
0000000009000000000
0000000000987654321
0000000009000000000
0000000008000000000
0000000007000000000
0000000006000000000
 00000000500000000
  000000040000000
  000000030000000
    00000200000
     432101234
     */

    public static void main(String[] args) {
        System.out.println(circle(10));
        System.out.println(circleWithStream(10));

    }

    public static String circle(int radius) {
        if (radius < 0) return "";
        if (radius == 0) return "\n";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < radius * 2 - 1; i++) {
            for (int j = 0; j < radius * 2 - 1; j++) {
                stringBuilder.append(Math.hypot(Math.abs(radius - 1 - i), Math.abs(radius - 1 - j)) < radius ? '\u2588' : ' ');
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String circleWithStream(int radius) {
        return radius < 0 ? "" :
                IntStream.range(-radius + 1, radius)
                        .mapToObj(i -> IntStream.range(-radius + 1, radius)
                                .mapToObj(j -> Math.hypot(i, j) < radius ? "\u2588" : " ")
                                .collect(Collectors.joining()))
                        .collect(Collectors.joining("\n")) + '\n';
    }
}
