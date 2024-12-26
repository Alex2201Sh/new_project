package by.aston.lesson12;

public class ExceptionExample2 {
    public static void main(String[] args) throws Exception {
        firstMethod();
    }

    private static void firstMethod() throws Exception {
        secondMethod();
    }

    private static void secondMethod() throws Exception {
//        throw new Exception();
    }

}
