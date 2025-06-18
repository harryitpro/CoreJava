package algorithms.basic;

/**
 * Problem Statement:
 * Given an array nums and an integer k, find the maximum sum of any contiguous subarray of length k.
 */

import java.util.Arrays;

/**
 * Approach:
 * <p>
 * Use a fixed-size window of k elements.
 * Compute the sum for the first k elements.
 * Slide the window by removing the first element and adding the next element.
 * Track the maximum sum.
 */

public class MaxSumOfContiguousSubarray {
    public static int maxSumSubarray(int[] nums, int k) {
        if (nums.length < k) return -1;

        int currentSum = Arrays.stream(nums).limit(k).sum();
        int maxSum = currentSum;

        int left = 0, right = k - 1;
        //start moving window using right index, right < nums.length
        for (right++; right < nums.length; right++) {
            currentSum += nums[right] - nums[left++];  // Slide the window
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}