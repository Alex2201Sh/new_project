package by.aston.livecoding.datastructures;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// false false false false true

public class BadHashSet {
    public static void main (String[] args) {
        MyObject obj = new MyObject(10);
        Set<MyObject> set = new HashSet<>();
        set.add(obj);
        obj.set(1000);

        System.out.println(set.contains(obj));
        System.out.println(set.contains(new MyObject(10)));
        System.out.println(set.contains(new MyObject(1000)));
        System.out.println(Objects.equals(new MyObject(1000), obj));
        System.out.println(obj.equals(new MyObject(1000)));
    }
}

class MyObject {
    private int i;
    public MyObject(int i) {
        this.i = i;
    }
    public void set(int i) {
        this.i = i;
    }
    public int hashCode() {
        return i;
    }
    public boolean equals(MyObject o) {
        return (o.i == this.i);
    }
}
