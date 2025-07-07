package algorithms.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Question: Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * <p>
 * Example: Input: n=4, k=2 → Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 */
public class CombinationsOfKElementsPractice {
    static List<List<Integer>> combine(int n, int k) {
        if (k > n) return null;
        if (k == n) {
            List<Integer> result = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
            return List.of(result);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombines = new ArrayList<>();
        combine(currentCombines, 1, n, k, result);
        return result;
    }

    static void combine(List<Integer> currentCombines, int start, int end, int k, List<List<Integer>> result) {
        //base case.
        if (currentCombines.size() == k) {
            result.add(currentCombines);
            return;
        }
        //traverse all dependent elements and perform combination logic recursively
        for (int i = start; i <= end; i++) { //traverse all dependent elements
            List<Integer> newCurrentCombines = new ArrayList<>(currentCombines);
            newCurrentCombines.add(i);  //perform combination logic
            combine(newCurrentCombines, start + 1, end, k, result); //call further dependent, DFS
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
