package algorithms.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumNoRemove {

    public List<List<Integer>> findCombinations(int[] candidates, int target) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        generateCombinations(allCombinations, new ArrayList<>(), candidates, target, 0);
        return allCombinations;
    }

    private void generateCombinations(List<List<Integer>> allCombinations, List<Integer> currentCombination,
                                      int[] candidates, int remainingTarget, int startIndex) {

        if (remainingTarget == 0) {
            allCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        if (remainingTarget < 0 || startIndex >= candidates.length) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            List<Integer> includeCurrent = new ArrayList<>(currentCombination);
            includeCurrent.add(candidates[i]);
            generateCombinations(allCombinations, includeCurrent, candidates, remainingTarget - candidates[i], i);
        }
    }

    public static void main(String[] args) {
        CombinationSumNoRemove solver = new CombinationSumNoRemove();
//
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
