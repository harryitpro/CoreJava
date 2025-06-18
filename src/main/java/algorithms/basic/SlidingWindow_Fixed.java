package algorithms.basic;

/**
 * Problem Statement:
 * Given an array nums and an integer k, find the maximum sum of any contiguous subarray of length k.
 */

/**
 * Approach:
 *
 * Use a fixed-size window of k elements.
 * Compute the sum for the first k elements.
 * Slide the window by removing the first element and adding the next element.
 * Track the maximum sum.
 */

public class SlidingWindow_Fixed {
    public static int maxSumSubarray(int[] nums, int k) {
        if (nums.length < k) return -1;

        int maxSum = 0, windowSum = 0;

        // Compute the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;

        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];  // Slide the window
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max Sum of Subarray of size " + k + ": " + maxSumSubarray(nums, k));
    }
}