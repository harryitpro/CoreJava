package algorithms.basic;

/**
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class MaximumSubarray {
    static int maxSubArray(int[] nums) {
        int[] currentMax = new int[nums.length];
        long maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                currentMax[i] = nums[i];
            } else {
                currentMax[i] = Math.max(currentMax[i - 1] + nums[i], nums[i]);
            }
            maxSum = Math.max(maxSum, currentMax[i]);
        }
        if (maxSum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

        nums = new int[]{5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));
    }

}
