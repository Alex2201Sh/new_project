package by.step.lesson10;

/**
 * https://gemini.google.com/share/a27789f970dc
 */
public class DecimalTypes {
    public static void main(String[] args) {
        int decimalNumber = 25;

        String binaryString = Integer.toBinaryString(decimalNumber);
        System.out.println(binaryString); // Вывод: 11001

        String octalString = Integer.toOctalString(decimalNumber);
        System.out.println(octalString); // Вывод: 31

        String hexString = Integer.toHexString(decimalNumber);
        System.out.println(hexString); // Вывод: 19


        String binaryString2 = "11001";
        int decimalNumber2 = Integer.parseInt(binaryString2, 2);
        System.out.println(decimalNumber2); // Вывод: 25

        String hexString2 = "19";
        int decimalNumber3 = Integer.parseInt(hexString2, 16);
        System.out.println(decimalNumber3); // Вывод: 25

        int binaryNumber = 0b1010; // 10
        int octalNumber = 077;    // 63
        int hexNumber = 0xFF;     // 255
    }
}
