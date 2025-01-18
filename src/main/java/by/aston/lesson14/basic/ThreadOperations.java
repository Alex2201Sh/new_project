package by.aston.lesson14.basic;


import java.util.concurrent.TimeUnit;

public class ThreadOperations {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main: Hello world!");

        Thread first = new Thread(new HelloRunnable(1));
        Thread second = new Thread(new HelloRunnable(2), "second thread name");
        Runnable greeting = () -> {
            System.out.println("This is greeting thread...  HELLO!!!");
            try {
//                Thread.currentThread().sleep(10000L);  //большое время засыпания для того, чтобы main успел отработать
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Greeting thread ended.");
        };
        Thread another = new Thread(greeting);
        Thread yetAnother = new Thread() {
            public void run() {
                super.run();
                System.out.println("sdfsdf");
            }
        };

//        another.setDaemon(true);
        first.start();
        second.start();
        another.start();
//        second.join();  //метод заставляет main поток ждать, пока выполнится поток second

        System.out.println("Main: Goodbye world.....");
    }
}
