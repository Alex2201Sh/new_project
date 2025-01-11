package by.aston.lesson12;

public class ExceptionExample {
    public static void main(String[] args) {
//        hereWillBeTrouble(10, 0);
        hereWillBeTrouble2(10, 0);
    }
    private static void hereWillBeTrouble(int a, int b) {
        int oops;
        try {
            System.out.println("Всё, что было до...");
            oops = a / b;
            System.out.println(oops);
            System.out.println("Всё, что будет после...");
        } catch (ArithmeticException e) {
            System.out.println("Говорили же не делить на ноль!");
            e.printStackTrace();
            oops = 0;
        } catch (RuntimeException e) {
            System.out.println("Говорили же не делить на ноль!");
            oops = 0;
        }
        System.out.println("Метод отработал");
        System.out.println(oops);
    }

    private static void hereWillBeTrouble2(int a, int b) {
//        if (b == 0) {
//            throw new ArithmeticException("ты опять делишь на ноль?");
//        }
        int oops = a / b;
        System.out.println(oops);
    }
}
