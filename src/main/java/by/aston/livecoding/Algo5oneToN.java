package by.aston.livecoding;

public class Algo5oneToN {

    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{2, 6, 3, 4, 7, 5}));
    }

    /*
    Дана упорядоченная последовательность чисел от 1 до N.
    Одно из чисел удалили. Оставшиеся перемешали в случайном порядке.
    Найти удалённое число
     */
    public static int findNumber(int[] array) {
        int arraySum = (array.length + 1) * (array.length + 2) / 2;
        for (int i = 0; i < array.length; i++) {
            arraySum -= array[i];
        }
    return arraySum;
    }
}
