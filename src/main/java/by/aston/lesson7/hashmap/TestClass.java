package by.aston.lesson7.hashmap;

import java.util.HashMap;

public class TestClass {
    public static void main(String[] args) {
        HashMap hashMap1 = new HashMap<>();
        HashMap hashMap2 = new HashMap<>(32);
        HashMap hashMap3 = new HashMap<>(64, 0.6f);
        HashMap hashMap4 = new HashMap(hashMap1);
    }
}
