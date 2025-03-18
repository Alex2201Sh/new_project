package by.aston.livecoding.datastructures;

import java.util.TreeMap;

public class TreeMapLeftRightExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(999,"999");
        map.put(1999,"1999");
        map.put(2999,"2999");
        map.put(3999,"3999");

        Integer lower = map.lowerKey(2000);
        Integer higher = map.higherKey(2000);
        System.out.println();

    }
}
