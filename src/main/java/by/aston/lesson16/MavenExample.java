package by.aston.lesson16;

import by.aston.util.MyCustomCalculator;

public class MavenExample {
    public static void main(String[] args) {
        MyCustomCalculator myCustomCalculator = new MyCustomCalculator();
        int sum = myCustomCalculator.sum(10, 20);
        System.out.println(sum);
    }
}
