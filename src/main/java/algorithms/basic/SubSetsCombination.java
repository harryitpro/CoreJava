package algorithms.basic;

import java.util.*;

public class SubSetsCombination {
    static List<List<Integer>> subsets(List<Integer> nums) {
        List<List<Integer>> allSubSets = new ArrayList<>();
        List<Integer> currentSubSet = new ArrayList<>();
        allSubSets.add(currentSubSet);
        int startIndex = 0;
        subsets(currentSubSet, nums, allSubSets, startIndex);
        return allSubSets;
    }


    static void subsets(List<Integer> currentSubSet, List<Integer> nums, List<List<Integer>> allSubSets, int startIndex) {
        for (int i = startIndex; i < nums.size(); i++) { //split each node as the root of sub tree
            List<Integer> newCurrentSubSet = new ArrayList<>(currentSubSet);
            newCurrentSubSet.add(nums.get(i));
            allSubSets.add(newCurrentSubSet);
            subsets(newCurrentSubSet, nums, allSubSets, i + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(List.of(1, 2, 3, 4)));
    }
}
