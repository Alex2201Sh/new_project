package by.aston.lesson14.exceptions;

public class Main {
    public static void main(String[] args) {
        MyClass myClass1 = new MyClass();
        MyClassChild classChild1 = new MyClassChild();

        try {
            myClass1.myMethod("abbb");
            classChild1.myMethod("abc");
        } catch (ChildOfMyCustomException e) {
            System.out.println("перехватили ChildOfMyCustomException");;
        } catch (MyCustomException e) {
            System.out.println("перехватили MyCustomException");;
        }

    }
}
