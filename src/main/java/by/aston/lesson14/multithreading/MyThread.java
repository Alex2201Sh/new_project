package by.aston.lesson14.multithreading;

public class MyThread extends Thread {

    public MyThread() {
        super();
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("work in thread: "
                + Thread.currentThread().getName());
    }
}
