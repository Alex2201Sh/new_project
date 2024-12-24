package by.aston.livecoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
https://www.codewars.com/kata/5254ca2719453dcc0b00027d

With input 'a':
Your function should return: ['a']

With input 'ab':
Your function should return ['ab', 'ba']

With input 'abc':
Your function should return ['abc','acb','bac','bca','cab','cba']

With input 'aabb':
Your function should return ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa']
 */
public class Algo4SoManyPermutations {
    public static List<String> singlePermutations(String s) {
        List lettersList = Arrays.asList(s.split(""));
        List<String> resultList = new ArrayList<>();

        IntStream.range(0, s.length() * 10000).forEach(value -> {
            Collections.shuffle(lettersList);
            resultList.add(streamToString(lettersList));
        });
        return resultList.stream().distinct().collect(Collectors.toList());
    }

    private static String streamToString(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringList.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
