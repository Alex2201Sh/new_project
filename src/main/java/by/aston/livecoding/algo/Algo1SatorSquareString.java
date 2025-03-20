package by.aston.livecoding.algo;

/*
https://www.codewars.com/kata/5cb7baa989b1c50014a53333
 */
public class Algo1SatorSquareString {
    /*
    The Square is a two-dimentional palindrome,
    made from words of equal length that can be read in these four ways:
    1)    left-to-right    (across)
    2)    top-to-bottom    (down)
    3)    bottom-to-top    (up)
    4)    right-to-left    (reverse)
    Example:
    B A T S
    A B U T
    T U B A
    S T A B
     */

    public static Boolean isSatorSquare(String str) {
        String[] lines = str.replaceAll(" ", "").split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                char leftChar = lines[i].charAt(j);
                char rightChar = lines[lines.length - i - 1].charAt(lines[i].length() - j - 1);
                char upChar = lines[j].charAt(i);
                char downChar = lines[lines.length - j - 1].charAt(lines[i].length() - i - 1);
                if (!(leftChar == rightChar && leftChar == upChar && leftChar == downChar)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] sampleTablets = {
                """
                T E N
                E Y E
                N E T
                """,
                """
                E V E
                E E E
                E E E
                """,
                """
                N O T
                O V O
                N O T
                """,
                """
                B A T S
                A B U T
                T U B A
                S T A B
                """,
                """
                B A T S
                Ä B U T
                T U B Ä
                S T A B
                """,
                """
                P A R T
                A G A R
                R A G A
                T R A M
                """,
                """
                S A T O R
                A R E P O
                T E N E T
                O P E R A
                R O T A S
                """,
                """
                S A L A S
                A R E N A
                L E V E L
                A R E N A
                S A L A S
                """,
                """
                9 $ [ 7 *
                $ $ v g +
                [ v X v [
                7 g v $ $
                * + [ $ 9
                """};

        for (int i = 0; i < sampleTablets.length; i++) {
            System.out.println(isSatorSquare(sampleTablets[i]) + " ---> " + (i % 3 == 0));
        }

    }
}

