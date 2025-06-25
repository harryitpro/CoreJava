package algorithms.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

//        int[] candidates1 = {2, 3, 6, 7};
//        int target1 = 7;
//        System.out.println("Candidates: " + Arrays.toString(candidates1) + ", Target: " + target1);
//        System.out.println("Combinations: " + solver.findCombinations(candidates1, target1));

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("\nCandidates: " + Arrays.toString(candidates2) + ", Target: " + target2);
        System.out.println("Combinations: " + solver.findCombinations(candidates2, target2));
    }
}
