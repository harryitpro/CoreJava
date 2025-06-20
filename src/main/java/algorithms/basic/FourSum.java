package algorithms.basic;

import algorithms.datasturctures.array.Array;

import java.util.*;

public class FourSum {
    //try two pointers solution
    List<List<Integer>> fourSum(int[] nums) {
        if (nums.length < 4) return null;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long currentSum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (currentSum == 0) {
                        result.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right++;
                        }
                    } else if (currentSum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
