package by.aston.livecoding;

/*
   12 --> "10 + 2"
   45 --> "40 + 5"
   70304 --> "70000 + 300 + 4"
 */
public class Algo3ExpandedNumbers {

    public static String expandedForm(int num) {
        String numInString = String.valueOf(num);
        StringBuilder stringBuilder = new StringBuilder();
        int length = numInString.length();
        for (int i = 0; i < length; i++) {
            char c = numInString.charAt(i);
            if ('0' != c) {
                if ((i < length) && (stringBuilder.length() > 0)) {
                    stringBuilder.append(" + ");
                }
                stringBuilder.append(c).append("0".repeat(length - i - 1));
            }
        }
        return stringBuilder.toString();
    }

}
