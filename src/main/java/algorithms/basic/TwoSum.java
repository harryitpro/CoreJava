package algorithms.basic;

import java.util.*;

public class TwoSum {
    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            long other = (long) target - nums[i]; //in case overflow
            if (other > Integer.MAX_VALUE || other < Integer.MIN_VALUE) continue;

            if (numToIndex.containsKey((int) other)) {
                return new int[]{numToIndex.get((int) other), i};
            } else {
                numToIndex.put(current, i);
            }
        }
        return null;
    }
}
