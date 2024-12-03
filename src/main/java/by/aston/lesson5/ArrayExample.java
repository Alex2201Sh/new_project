package by.aston.lesson5;

public class ArrayExample {
    public static void main(String[] args) {
        int[] ints = new int[1_000_000];
        int first = ints[0];
        int last = ints[999_999];

        for (int i = 0; i < ints.length; i++) {
            if (ints[i]==555){
                System.out.println("Good");
            }
        }



    }
}
