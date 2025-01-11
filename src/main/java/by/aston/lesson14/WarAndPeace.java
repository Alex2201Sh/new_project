package by.aston.lesson14;

import java.io.File;

public class WarAndPeace {

    public int countWords(String text, String word) { //хорошо для тестов
        return 0;
    }

    public int countWords(String word) {  //плохо для тестов
        String text = "read from file";
        return 1;
    }
    public int countWords(File file, String word){  //хорошо для тестов
        return 2;
    }
}
