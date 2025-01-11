package by.aston.lesson12;

public class Main implements AutoCloseable {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        while (true) {
            Main a = new Main();
            sb.append(a.toString());
            Thread.sleep(0,1);
        }
    }

    @Override
    public void close() throws Exception {
    }
}