package by.aston.lesson9;

public class OOMExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        while (true) {
            OOMExample a = new OOMExample();
            sb.append(a.toString());
            sb = new StringBuffer();
        }
    }
}
