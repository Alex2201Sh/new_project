package by.aston.livecoding.algo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.codewars.com/kata/5ed056c9263d2f001738b791/train/java
 */
public class Algo11GroupAndSum {
//    public static Map<List<Integer>, List<Integer>> groupAndSum(final int[][] data, final int[] indices) {
//        Function<int[], List<Integer>> indecesFunction = ints -> {
//            int[] indicesValues = new int[indices.length];
//            for (int i = 0; i < indices.length; i++) {
//                indicesValues[i] = ints[indices[i]];
//            }
//            return Arrays.stream(indicesValues).boxed().toList();
//        };
//
//        Map<List<Integer>, List<Integer>> resultMap = new LinkedHashMap<>();
//        Map<List<Integer>, List<int[]>> collect = Arrays.stream(data)
//                .collect(Collectors.groupingBy(indecesFunction, ));
//        collect.forEach((integers, ints) ->
//
//                {
//                    if (ints.size() == 1) {
//                        resultMap.put(integers, Arrays.stream(ints.get(0)).boxed().toList());
//                    } else {
//                        List<List<Integer>> list = ints.stream().map(ints1 -> {
//                                    for (int j = 0; j < indices.length; j++) {
//                                        ints1[indices[j]] = 0;
//                                    }
//                                    return Arrays.stream(ints1).filter(value -> value > 0).boxed().toList();
//                                })
//                                .toList();
//                        List<Integer> someList = new ArrayList<>();
//                        for (int i = 0; i < list.get(0).size(); i++) {
//                            int sum = 0;
//                            for (int j = 0; j < list.size(); j++) {
//                                sum += list.get(j).get(i);
//                            }
//                            someList.add(sum);
//                        }
//                        resultMap.put(integers, someList);
//                    }
//                }
//        );
//
//        return resultMap;
//    }

    public static Map<List<Integer>, List<Integer>> groupAndSum(int[][] data, int[] indices) {
        Map<List<Integer>, List<Integer>> result = new HashMap<>();
        List<Integer> idx = Arrays.stream(indices).boxed().toList();
        List<List<Integer>> arr = Arrays.stream(data).map(ints -> Arrays.stream(ints).boxed().toList()).toList();
        // Определяем индексы столбцов, которые нужно суммировать (не входящие в idx)
        List<Integer> sumIndices = new ArrayList<>();
        for (int i = 0; i < arr.get(0).size(); i++) {
            if (!idx.contains(i)) {
                sumIndices.add(i);
            }
        }
        for (List<Integer> row : arr) {
            // Ключ группировки — список из значений столбцов idx
            List<Integer> key = new ArrayList<>();
            for (int i : idx) {
                key.add(row.get(i));
            }
            if (!result.containsKey(key)) {
                // Инициализируем список сумм нулями
                List<Integer> sums = new ArrayList<>();
                for (int i = 0; i < sumIndices.size(); i++) {
                    sums.add(0);
                }
                result.put(key, sums);
            }
            // Прибавляем значения к соответствующим суммам
            List<Integer> sums = result.get(key);
            for (int j = 0; j < sumIndices.size(); j++) {
                int sumIdx = sumIndices.get(j);
                sums.set(j, sums.get(j) + row.get(sumIdx));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final int[][] data1 = {{1, 2, 3}, {1, 5, 6}, {1, 8, 9}};
        final int[] indices1 = {0};
        final Map<List<Integer>, List<Integer>> expected1 = Map.of(List.of(1), List.of(15, 18));
        System.out.println(expected1.equals(groupAndSum(data1, indices1)));

        final int[][] data2 = {{1, 1, 1}, {1, 2, 1}, {1, 3, 1}};
        final int[] indices2 = {0, 2};
        final Map<List<Integer>, List<Integer>> expected2 = Map.of(List.of(1, 1), List.of(6));
        System.out.println(expected2.equals(groupAndSum(data2, indices2)));

        final int[][] data3 = {{1, 2, 3}, {4, 5, 6}, {6, 7, 8}};
        final int[] indices3 = {0, 1, 2};
        final Map<List<Integer>, List<Integer>> expected3 = Map.of(
                List.of(1, 2, 3), List.of(),
                List.of(4, 5, 6), List.of(),
                List.of(6, 7, 8), List.of()
        );
        System.out.println(expected3.equals(groupAndSum(data3, indices3)));
    }
}
