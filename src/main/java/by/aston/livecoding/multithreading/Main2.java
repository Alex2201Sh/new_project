package by.aston.livecoding.multithreading;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(foo());
        interface A {
            
        }
    }

    static int foo(){
        try {
            Some some = null;
            return some.i;
        } catch (Exception e){
            return 2;
        } finally {
            return 4;
        }
    }
}

class Some{
    public static int i = 1;
}
