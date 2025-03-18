//package by.aston.livecoding;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///*
//https://www.codewars.com/kata/5254ca2719453dcc0b00027d
//
//With input 'a':
//Your function should return: ['a']
//
//With input 'ab':
//Your function should return ['ab', 'ba']
//
//With input 'abc':
//Your function should return ['abc','acb','bac','bca','cab','cba']
//
//With input 'aabb':
//Your function should return ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa']
// */
//public class Algo4SoManyPermutations2 {
//    public static void main(String[] args) {
//        singlePermutations("abcd");
//    }
//
////    public static List<String> singlePermutations(String s) {
////        List<String> list = Arrays.stream(s.split("")).toList();
////        List<List<String>> words = new ArrayList<>();
////        list.stream()
////                .flatMap(s1 -> {
////                    ArrayList<String> strings = new ArrayList<>(list);
////                    strings.remove(s1);
////                    strings.add(0, s1);
////                    return strings.stream();
////                })
////                .forEach(s1 -> {
////                    if (words.isEmpty() || words.get(words.size() - 1).size() == s.length()) {
////                        ArrayList<String> word = new ArrayList<>();
////                        word.add(s1);
////                        words.add(word);
////                    } else {
////                        List<String> lastWord = words.get(words.size() - 1);
////                        lastWord.add(s1);
////                    }
////
////                });
////        System.out.println(words);
////        return null;
////    }
//
//    public static List<String> singlePermutations(String s) {
//        List<String> letters = Arrays.stream(s.split("")).toList();
//        List<String> words = new ArrayList<>();
//        StringBuilder word = new StringBuilder();
//
//        for (int i = 0; i < letters.size(); i++) {
//            word.append(letters.get(i));
//            ArrayList<String> restLetters = new ArrayList<>(letters);
//
//        }
//    }
//
//
//}
