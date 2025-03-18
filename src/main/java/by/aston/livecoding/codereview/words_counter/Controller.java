package by.aston.livecoding.codereview.words_counter;

import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            new Thread(() -> {
                ArrayList<String> words = WordCounter.getWords();
                System.out.println(words);
            }).start();
        }
    }
}
