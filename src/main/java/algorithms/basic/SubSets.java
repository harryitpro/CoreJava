package algorithms.basic;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    static List<List<Integer>> subsets(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        //add initial empty List
        result.add(List.of());
        //get subsets that containing k element each loop. k ranges [1,N]
        for (int k = 1; k <= nums.size(); k++) {
            List<Integer> preSet = new ArrayList<>();
            subsets(nums, 0, k, preSet, result);
        }
        return result;
    }

    //recursive method
    static void subsets(List<Integer> nums, int start, int k, List<Integer> preSet, List<List<Integer>> result) {
        if (k == 0) {
            result.add(preSet);
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            if ((nums.size() - i) < k) {
                break;
            }
            List<Integer> newPreSet = new ArrayList<>(preSet);
            newPreSet.add(nums.get(i));
            subsets(nums, 1 + i, k - 1, newPreSet, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(List.of(1, 2, 3)));
    }
}
