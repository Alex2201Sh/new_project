package by.aston.livecoding.codereview.words_counter;

import java.util.ArrayList;

@Service
@Slf4j
public class WordCounter {
    private static final int wordCount = 10;
    private static ArrayList<String> stringList;

    public static ArrayList<String> getWords() {
        stringList = new ArrayList<>();
        String response = requestRandomWords();
        for (int i = 0; i < wordCount; i++) {
            try {
                stringList.add(new JSONArray(response).getJSONObject(i).getString("word"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }

    private static String requestRandomWords() {
        //go to some resource and return JSON
        return WordCounterUtils.REQUEST_JSON;
    }
}
