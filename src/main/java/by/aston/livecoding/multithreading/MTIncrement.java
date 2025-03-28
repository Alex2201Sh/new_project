package by.aston.livecoding.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class MTIncrement {
    //    static volatile long value = 0;
    static long value = 0;
    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
//        long start = System.currentTimeMillis();
        incrementMethod();
//        long end = System.currentTimeMillis();
//        System.out.println(value + " " + (end - start));
//        System.out.println(atomicInteger + " " + (end - start));
        System.out.println(atomicInteger);
    }

    private static void incrementMethod() {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    value++;
                    atomicInteger.incrementAndGet();
                }
            }).start();
        }
//        threadSizeVerifier();
    }

    private static void threadSizeVerifier() {
        int size = Thread.getAllStackTraces().size();
        while (size > 8) {
            size = Thread.getAllStackTraces().size();
        }
    }
}
