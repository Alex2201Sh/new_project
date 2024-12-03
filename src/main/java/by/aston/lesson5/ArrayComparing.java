package by.aston.lesson5;

import java.util.Arrays;

public class ArrayComparing {
    public static void main(String[] args) {
        int[] ints1 = {1,2,3};
        int[] ints2 = {1,2,3};
        System.out.println(ints1==ints2);
        System.out.println(ints1);
        System.out.println(ints2);
        System.out.println(Arrays.equals(ints1,ints2));


    }
}
