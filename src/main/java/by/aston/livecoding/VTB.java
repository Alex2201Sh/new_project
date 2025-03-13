package by.aston.livecoding;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VTB {
    public static void main(String[] args) {
        MyObject obj = new MyObject(10);
        // MyObject obj2 = new MyObject(10);
        Set<MyObject> set = new HashSet<>();
        set.add(obj);
//        obj.set(1000);

        System.out.println(set.contains(obj)); // false
        System.out.println(set.contains(new MyObject(10))); // false
        System.out.println(set.contains(new MyObject(1000))); // false
        System.out.println(Objects.equals(new MyObject(1000), obj)); // false

        System.out.println(obj.equals(new MyObject(1000))); // true
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
        return i; //(i + count) * 31
    }

    public boolean equals(MyObject o) {
        return (o.i == this.i);
    }
}
