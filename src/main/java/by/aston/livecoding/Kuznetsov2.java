package by.aston.livecoding;

import by.aston.livecoding.clev.model.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Kuznetsov2<T> {

    private final List<T>[] data;

    public Kuznetsov2(int capacity) {
        this.data = new List[capacity];
    }

    public void add(T value) {

        int index = Math.abs(value.hashCode()) % data.length;
        List<T> list = data[index];

        if (list == null || list.isEmpty()) {
            List<T> objects = new ArrayList<>();
            objects.add(value);
            data[index] = objects;
        } else {
            for (int i = 0; i < list.size(); i++) {
                T t = list.get(i);
                if (t.hashCode()==value.hashCode() && t.equals(value)) {
                    return;
                }
            }
            list.add(value);
        }
    }

    public static void main(String[] args) {
        Kuznetsov2<Animal> bounded = new Kuznetsov2<>(2);

        Animal animal1 = new Animal(1, "a", 1, "A", "male");
        Animal animal2 = new Animal(2, "a", 1, "A", "male");
        Animal animal3 = new Animal(3, "a", 1, "A", "male");
        Animal animal4 = new Animal(4, "a", 1, "A", "male");
        Animal animal5 = new Animal(5, "a", 1, "A", "male");

        bounded.add(animal1);
        bounded.add(animal2);
        bounded.add(animal3);
        bounded.add(animal4);
        bounded.add(animal5);



        Kuznetsov2<Integer> bounded2 = new Kuznetsov2<>(2);

        bounded2.add(1);
        bounded2.add(2);
        bounded2.add(3);
        bounded2.add(4);
        bounded2.add(4);
        bounded2.add(2);
        bounded2.add(2);

        System.out.println();

    }
}
