package by.aston.lesson14.syncro;

import java.util.stream.IntStream;

public class SynchronizedThread {

    public static void main(String[] args) {
        CommonObject commonObject = new CommonObject();
        IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new Thread(new CounterThread(commonObject),
                        "Поток" + i))
                .forEach(Thread::start);

    }
}


