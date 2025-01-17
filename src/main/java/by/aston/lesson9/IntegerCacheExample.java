package by.aston.lesson9;

public class IntegerCacheExample {
    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 == i2);
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i3 == i4);
        Integer i5 = Integer.valueOf(100);
        Integer i6 = Integer.valueOf(200);
        System.out.println(i1==i5);
        System.out.println(i3==i6);

    }
}
