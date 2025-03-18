package by.aston.livecoding.inheritance;

public class InheritanceExample {
    public static void main(String[] args) {
        A obj = new B();
        obj.print();
        obj.nonStaticPrint();
    }
}

class A{
    public static void print(){
        System.out.println("static A");
    }
    public void nonStaticPrint(){
        System.out.println("non-static A");
    }
}

class B extends A{
    public static void print(){
        System.out.println("static B");
    }
    public void nonStaticPrint(){
        System.out.println("non-static B");
    }
}