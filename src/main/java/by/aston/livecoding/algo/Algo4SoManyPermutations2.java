package by.aston.livecoding.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
public class Algo4SoManyPermutations2 {
    public static void main(String[] args) {
        List<String> abcd = Permutations.singlePermutations("abc");
        System.out.println(abcd);
    }


}

class Permutations {

    public static List<String> singlePermutations(String s) {
        var solution = new Solution();
        var nums = solution.encodeStringToLengthOfCollection(s);
        var permutations = solution.permute(nums);
        var result = new LinkedList<String>();
        for (var lst : permutations) {
            result.add(solution.decodeStringFromMap(lst));
        }
        return result.stream().distinct().toList();
    }
}

class Solution {

    private List<List<Integer>> permutations = new ArrayList<>();

    private List<Integer> currentPermutation = new ArrayList<>();

    private boolean[] visited;

    private int[] elements;

    private HashMap<Integer, String> map = new HashMap<>();

    public List<List<Integer>> permute(int[] nums) {
        elements = nums;
        visited = new boolean[nums.length];
        backtrack(0);
        return permutations;
    }

    private void backtrack(int index) {
        if (index == elements.length) {
            permutations.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (var j = 0; j < elements.length; ++j) {
            if (!visited[j]) {
                visited[j] = true;
                currentPermutation.add(elements[j]);
                backtrack(index + 1);
                currentPermutation.remove(currentPermutation.size() - 1);
                visited[j] = false;
            }
        }
    }

    public int[] encodeStringToLengthOfCollection(String input) {
        for (var i = 0; i < input.length(); ++i) {
            this.map.put(i, input.charAt(i) + "");
        }
        return IntStream.range(0, input.length()).toArray();
    }

    public String decodeStringFromMap(List<Integer> numbers) {
        var builder = new StringBuilder();
        for (Integer number : numbers) {
            builder.append(map.getOrDefault(number, ""));
        }
        return builder.toString();
    }

}
