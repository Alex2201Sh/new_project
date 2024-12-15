package by.aston.lesson9;

public class StringPoolExample {
    public static void main(String[] args) {
        String str0;  // pool : ""
        String str1 = "war";  // pool : "war"
        String str2 = "war"; // pool: "war"
        String str3 = new String("war");
        String str4 = new String("war").intern();
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);

        // some     war      some     peace    war
        // ссылка№1 ссылка№2 ссылка№1 ссылка№3 ссылка№2

        String longString = "first " + "second " + "third ";
        //"first "
        //"first ", "first second "
        //"first ", "first second ", "first second third"

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("first ").append("second ").append("third ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("first ").append("second ").append("third ");




    }
}
