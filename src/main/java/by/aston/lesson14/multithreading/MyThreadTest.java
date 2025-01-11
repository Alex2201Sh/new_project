package by.aston.lesson14.multithreading;

public class MyThreadTest {
    public static void main(String[] args) {


        System.out.println(Thread.currentThread().getName() + " "
                + Thread.currentThread().getPriority());


        for (int i = 0; i < 100; i++) {
            MyThread myThread1 = new MyThread("MyThread1 + " + i);
            MyThread myThread2 = new MyThread("MyThread2 + " + i);
            myThread1.start();
            myThread2.start();
        }

    }
}
