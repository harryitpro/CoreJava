package algorithms.arrays;

public class MergeSortedArray {
    //Two pointers.
    static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int j = 0, k = 0;
        for (int i = 0; i < merged.length; i++) {
            if (j == arr1.length) merged[i] = arr2[k++];
            else if (k == arr2.length) merged[i] = arr1[j++];
            else if (arr1[j] <= arr2[k]) merged[i] = arr1[j++];
            else merged[i] = arr2[k++];
        }
        return merged;
    }
}
