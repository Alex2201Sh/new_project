package by.aston.lesson15.loks.readwritelock;

import static java.lang.Thread.sleep;

public class Writer implements Runnable {

    SynchronizedHashMapWithRWLock object;

    public Writer(SynchronizedHashMapWithRWLock object) {
        this.object = object;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                object.put("key" + i, "value" + i);
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
