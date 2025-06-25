package algorithms.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * <p>
 * Example: Input: n=4, k=2 → Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 */
public class CombinationsOfKElements {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allCombines = new ArrayList<>();
        List<Integer> currentCombines = new ArrayList<>();
        int startNum = 1;
        //k as full length
        combine(n, startNum, k, currentCombines, allCombines);
        return allCombines;
    }

    static void combine(int maxNum, int startNum, int length, List<Integer> currentCombines, List<List<Integer>> allCombines) {
        if (currentCombines.size() == length) {
            allCombines.add(currentCombines);
            return;
        }
        for (int i = startNum; i <= maxNum; i++) {
            List<Integer> newCurrentCombines = new ArrayList<>(currentCombines);
            newCurrentCombines.add(i);
            combine(maxNum, i + 1, length, newCurrentCombines, allCombines);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
