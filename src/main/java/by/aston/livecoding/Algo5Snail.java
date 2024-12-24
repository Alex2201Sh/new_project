package by.aston.livecoding;
/*
https://www.codewars.com/kata/5b93fecd8463745630001d05/train/java

Your function takes three arguments:

The height of the column (meters)
The distance that the snail crawls during the day (meters)
The distance that the snail slides down during the night (meters)

Calculate number of day when the snail will reach the top of the column.

 */
public class Algo5Snail {

    public static int snail(int column, int day, int night) {
        int height = 0;
        int result = 0;
        while (height < column) {
            height = height + day;
            result++;
            if (height < column) {
                height -= night;
            }
        }
        return result;
    }

    /*
    test
        (2, snail(3,2,1));
        (5, snail(10,3,1));
        (8, snail(10,3,2));
        (7, snail(100,20,5));
        (1, snail(5,10,3));
     */
}
