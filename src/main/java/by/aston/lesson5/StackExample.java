package by.aston.lesson5;

public class StackExample {
    public static void main(String[] args) {
        first();
    }

    static void first() {
        System.out.println("first before");
        second();
        System.out.println("first after");
    }

    static void second() {
        System.out.println("second before");
        third();
        System.out.println("second after");

    }

    static void third() {
        System.out.println("third");
    }
}
