package algorithms.basic;

import java.util.HashSet;
import java.util.Set;

public class Set_LargestMissingNumber {

    public static int findLargestMissing(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int largestMissing = -1;
        for (int i = min; i < max; i++) {
            if (!set.contains(i)) {
                largestMissing = i;  // keep updating to get the *largest* missing
            }
        }

        return (largestMissing == -1) ? max + 1 : largestMissing;
    }

    public static void main(String[] args) {
        int[] a1 = {3, 7, 1, 2, 8, 4, 5}; // → 6
        int[] a2 = {1, 2, 3, 4};         // → 5
        int[] a3 = {10, 11, 14, 12};     // → 13

        System.out.println(findLargestMissing(a1));
        System.out.println(findLargestMissing(a2));
        System.out.println(findLargestMissing(a3));
    }
}


