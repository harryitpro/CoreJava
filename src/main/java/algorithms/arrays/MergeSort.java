package algorithms.arrays;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    //recursive method for merge sort
    public static void mergeSort(int[] arr, int left, int right) {
        //base condition. returning condition
        if (left >= right) return;

        // divide by half, sort each half
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        //create 2 auxiliary arrays to represent sorted left and right arrays
        int[] auxLeft = Arrays.copyOfRange(arr, left, mid + 1);
        int[] auxRight = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0; //i: index of left array, j: index of right array

        // Merge left and right sub array back into original array
        for (int k = left; k <= right; k++) {
            if (i == auxLeft.length) {
                arr[k] = auxRight[j++];
            } else if (j == auxRight.length) {
                arr[k] = auxLeft[i++];
            } else if (auxLeft[i] < auxRight[j]) {
                arr[k] = auxLeft[i++];
            } else {
                arr[k] = auxRight[j++];
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {38, 27, 10, 43, 3, 9, 82, 10};
        System.out.println("Original array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        /**
         * output:
         Original array: [38, 27, 10, 43, 3, 9, 82, 10]
         Sorted array: [3, 9, 10, 10, 27, 38, 43, 82]
         */
    }
}

