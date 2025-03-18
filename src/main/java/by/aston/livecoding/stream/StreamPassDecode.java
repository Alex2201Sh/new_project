package by.aston.livecoding.stream;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPassDecode<T> {

    public static void main(String[] args) {
        List<List<String>> lists = List.of(
                List.of("dwadawdadaw","dwaefrsfese"),
                List.of("dwaefrsfeseeee","wertyjukmnbdsefgrtfhbg"),
                List.of("rergthyjuk","rergthyjukeeee")
        );

        String collect = lists.stream()
                .flatMap(strings -> strings.stream())
                .map(s -> new String(Base64.getDecoder().decode(s)))
//                .peek(System.out::println)
                .collect(Collectors.joining(", "));

        System.out.println(collect);
    }
}
