package by.aston.livecoding.algo;

public class Algo10PhoneNumber {

    public static void main(String[] args) {
        /*
        "(123) 456-7890"  => true
        "(1111)555 2345"  => false
        "(098) 123 4567"  => false
         */
        System.out.println(validPhoneNumber("(123) 456-7890"));
    }
    public static boolean validPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("([(])(\\d{3})([)])(\\s)(\\d{3})([-])(\\d{4})");
    }
}
