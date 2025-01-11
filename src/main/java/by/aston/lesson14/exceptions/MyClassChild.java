package by.aston.lesson14.exceptions;

public class MyClassChild extends MyClass {

    @Override
    public void myMethod(String str) throws ChildOfMyCustomException {
        if (str.length() < 5) throw new ChildOfMyCustomException();
    }
}
