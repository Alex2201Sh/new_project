package by.aston.lesson12;

public class FactorialExample {
    public static void main(String[] args) {
        int factorial = 0;
        int value = 0;
        try {
            value = -1;
            factorial = Factorial.getFactorial(value);
        } catch (FactorialException e) {
            System.out.println("Число " + value + " неправильное");
        }
        System.out.println(factorial);
    }
}
