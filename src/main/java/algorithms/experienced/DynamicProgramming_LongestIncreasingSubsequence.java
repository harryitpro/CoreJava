package algorithms.experienced;

import java.util.Arrays;

/**
 * Longest Increasing Subsequence (LIS)
 * The Longest Increasing Subsequence (LIS) of an array is the longest subsequence where elements are in increasing order.
 * <p>
 * Example
 * Input:  nums = [10, 9, 2, 5, 3, 7, 101, 18]
 * Output: 4
 * Explanation: The LIS is [2, 3, 7, 101]
 */


/**
 * Explanation
 * Base Case:
 * If the input array is null or empty, the length of the LIS is 0.
 * DP Array:
 * We use an array dp[] where dp[i] represents the length of the longest increasing subsequence that ends at index i.
 * Initially, every element is a subsequence of length 1 (itself), so we initialize dp[i] = 1 for all i.
 * Main Logic:
 * For each position i, we look at all previous positions j (where j < i).
 * If nums[i] > nums[j], it means we can append nums[i] to the subsequence ending at j. In this case, the length of the subsequence ending at i can be dp[j] + 1.
 * We take the maximum of all such possibilities to update dp[i].
 * Tracking Maximum Length:
 * While computing dp[i], we keep track of the overall maximum length (maxLength) seen so far, as the LIS might not necessarily end at the last element.
 */
public class DynamicProgramming_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp[i] represents the length of LIS ending at index i
        int[] dp = new int[nums.length];
        // Initialize all positions to 1 (each number is a subsequence of length 1)
        Arrays.fill(dp, 1);
        int maxLength = 1;

        // For each position i
        for (int i = 1; i < nums.length; i++) {
            // Check all previous positions j
            for (int j = 0; j < i; j++) {
                // If we can append nums[i] to subsequence ending at j
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        DynamicProgramming_LongestIncreasingSubsequence solution = new DynamicProgramming_LongestIncreasingSubsequence();
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(nums1));  // Output: 4

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println(solution.lengthOfLIS(nums2));  // Output: 4

        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(solution.lengthOfLIS(nums3));  // Output: 1
    }
}
