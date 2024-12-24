package by.aston.livecoding;

import java.util.HashMap;
import java.util.Map;

public class Stream5 {
    /*
    Что будет результатом? (выбрать один)
a) [4, 3]
b) [1, 3]
c) [2, 4]
d) [2, 4]
e) runtime error
     */
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.compute("y", (k, v) -> v==null ? 1 : 0);
        map.compute("z", (k, v) -> v==null ? 2 : 0);
        map.computeIfPresent("z", (k, v) -> v!=null ? 3 : 0);
        map.computeIfAbsent("y", v -> v!=null ? 4 : 0);
        System.out.println(map.values());
    }
}
