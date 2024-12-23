package by.aston.lesson11;

public class StringExample {
    public static void main(String[] args) {
        String str = "Abc dhweof, abc, 243564trwefd abr";
        int counter = 0;
        int lastPosition = 0;

        String[] s = str.split("[\s]|[,]");
        System.out.println(s);

        while (str.toLowerCase().indexOf("abc".toLowerCase(),lastPosition) >= 0){
            counter++;
            lastPosition = str.indexOf("abc",lastPosition) + "abc".length();
        }

        System.out.println(counter);
    }
}
