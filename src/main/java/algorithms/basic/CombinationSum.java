package algorithms.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement (General Version):
 * Given:
 * A set (or array) of distinct integers (let's call them candidates).
 * A target integer.
 * Find:
 * All unique combinations of numbers from candidates where the chosen numbers sum up to the target.
 */
public class CombinationSum {

    public List<List<Integer>> findCombinations(int[] nums, int target) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        generateCombinationsRecursive(allCombinations, currentCombination, nums, target, 0);
        return allCombinations;
    }

    private void generateCombinationsRecursive(List<List<Integer>> allCombinations, List<Integer> currentCombination,
                                               int[] candidates, int remainingTarget, int startIndex) {

        if (remainingTarget == 0) {
            allCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        if (remainingTarget < 0) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            int num = candidates[i];
            List<Integer> newCurrentCombination = new ArrayList<>(currentCombination);
            newCurrentCombination.add(num);
            generateCombinationsRecursive(allCombinations, newCurrentCombination, candidates, remainingTarget - num, i);
        }
    }

    public static void main(String[] args) {
        CombinationSum solver = new CombinationSum();

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("\nCandidates: " + Arrays.toString(candidates2) + ", Target: " + target2);
        System.out.println("Combinations: " + solver.findCombinations(candidates2, target2));
    }
}
