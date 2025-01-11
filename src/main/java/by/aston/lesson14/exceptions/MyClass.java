package by.aston.lesson14.exceptions;

public class MyClass {
    public void myMethod(String str) throws MyCustomException {
        if (str.isBlank()) throw new MyCustomException();
        System.out.println("MyClass.myMethod :" + str);
    }
}
