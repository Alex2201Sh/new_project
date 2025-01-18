package by.aston.lesson15.loks.readwritelock;

public class Reader implements Runnable {

    SynchronizedHashMapWithRWLock object;

    Reader(SynchronizedHashMapWithRWLock object) {
        this.object = object;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            object.get("key" + i);
        }
    }
}