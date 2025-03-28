package by.aston.livecoding.algo;


public class Algo1SatorSquare {

    /*
    TASK:
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
    https://www.codewars.com/kata/5cb7baa989b1c50014a53333
     */

    /**
     * Student solving
     *
     * @param tablet
     * @return
     */
    public static Boolean isSatorSquare(char[][] tablet) {
        throw new IllegalArgumentException();
    }

    /**
     * Testing
     *
     * @param args
     */
    public static void main(String[] args) {
        Object[] sampleTablets = {
                new char[][]{{'T', 'E', 'N'}, {'E', 'Y', 'E'}, {'N', 'E', 'T'}}, Boolean.TRUE,
                new char[][]{{'E', 'V', 'E'}, {'E', 'E', 'E'}, {'E', 'E', 'E'}}, Boolean.FALSE,
                new char[][]{{'N', 'O', 'T'}, {'O', 'V', 'O'}, {'N', 'O', 'T'}}, Boolean.FALSE,
                new char[][]{{'B', 'A', 'T', 'S'}, {'A', 'B', 'U', 'T'},
                        {'T', 'U', 'B', 'A'}, {'S', 'T', 'A', 'B'}}, Boolean.TRUE,
                new char[][]{{'B', 'A', 'T', 'S'}, {'Ä', 'B', 'U', 'T'},
                        {'T', 'U', 'B', 'Ä'}, {'S', 'T', 'A', 'B'}}, Boolean.FALSE,
                new char[][]{{'P', 'A', 'R', 'T'}, {'A', 'G', 'A', 'R'},
                        {'R', 'A', 'G', 'A'}, {'T', 'R', 'A', 'M'}}, Boolean.FALSE,
                new char[][]{{'S', 'A', 'T', 'O', 'R'},
                        {'A', 'R', 'E', 'P', 'O'},
                        {'T', 'E', 'N', 'E', 'T'},
                        {'O', 'P', 'E', 'R', 'A'},
                        {'R', 'O', 'T', 'A', 'S'}}, Boolean.TRUE,
                new char[][]{{'S', 'A', 'L', 'A', 'S'},
                        {'A', 'R', 'E', 'N', 'A'},
                        {'L', 'E', 'V', 'E', 'L'},
                        {'A', 'R', 'E', 'N', 'A'},
                        {'S', 'A', 'L', 'A', 'S'}}, Boolean.FALSE,
                new char[][]{
                        {'9', '$', '[', '7', '*'},
                        {'$', '$', 'v', 'g', '+'},
                        {'[', 'v', 'X', 'v', '['},
                        {'7', 'g', 'v', '$', '$'},
                        {'*', '+', '[', '$', '9'}}, Boolean.FALSE
        };
        for (int i = 0; i < sampleTablets.length; i = i + 2) {
            if (isSatorSquare2((char[][]) sampleTablets[i]) != sampleTablets[i + 1]) {
                System.out.println("Incorrect solving");
                return;
            }
        }
        System.out.println("All OK.");
    }
//---------------------------------------------------------------

    /**
     * Possible solving
     *
     * @param tablet
     * @return
     */
    public static Boolean isSatorSquare2(char[][] tablet) {
        for (int i = 0; i < tablet.length; i++) {
            for (int j = 0; j < tablet[i].length; j++) {
                char leftChar = tablet[i][j];
                char rightChar = tablet[tablet.length - i - 1][tablet[i].length - j - 1];
                char upChar = tablet[j][i];
                char downChar = tablet[tablet.length - j - 1][tablet[i].length - i - 1];
                if (!(leftChar == rightChar && leftChar == upChar && leftChar == downChar)) {
                    return false;
                }
            }
        }
        return true;
    }
}

