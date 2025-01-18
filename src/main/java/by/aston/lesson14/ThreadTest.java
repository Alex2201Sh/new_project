package by.aston.lesson14;

public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new InnerThread());
        System.out.println("* " + Thread.currentThread().getName());
        thread.start();
//        thread.run();
    }

    static class InnerThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
