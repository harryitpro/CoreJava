package algorithms.basic;

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
public class LongestIncreasingSubsequence {
    static int lis(int[] nums) {
        int overallMaxLength = 0;
        int[] maxLengths = new int[nums.length]; //Note: With Item Included
        maxLengths[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            int currentMaxLength = 0;
            //compare currentNum with its left nums
            for (int j = i - 1; j >= 0; j--) {
                if (currentNum > nums[j]) {
                    currentMaxLength = Math.max(maxLengths[j], currentMaxLength);
                }
            }
            maxLengths[i] = currentMaxLength + 1;
            overallMaxLength = Math.max(overallMaxLength, maxLengths[i]);
        }
        return overallMaxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 20, 1, 2, 3};
        System.out.println(lis(nums1));  // Output: 4
    }
}
