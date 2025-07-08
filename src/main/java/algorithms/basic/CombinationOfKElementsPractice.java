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
public class CombinationOfKElementsPractice {
    static List<List<Integer>> combine(int n, int k) {
        if (k > n) return null;
        if (k == n) {
            List<Integer> singleResult = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
            return List.of(singleResult);
        }
        List<List<Integer>> result = new ArrayList<>();
        //start building recursive combine

        List<Integer> currentCombines = new ArrayList<>();
        combineNum(currentCombines, 1, n, k, result);
        return result;
    }

    static void combineNum(List<Integer> currentCombines, int from, int to, int depth, List<List<Integer>> result) {
        //base case: return to called instead of further calling dependent
        if (currentCombines.size() == depth) {
            result.add(currentCombines);
            return;
        }

        //perform logic and apply DFS call
        for (int i = from; i <= to; i++) {
            List<Integer> newcurrentCombines = new ArrayList<>(currentCombines);
            newcurrentCombines.add(i);
            combineNum(newcurrentCombines, i + 1, to, depth, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 3));
    }
}
