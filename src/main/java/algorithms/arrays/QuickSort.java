package algorithms.arrays;

import java.util.Arrays;

import static algorithms.datasturctures.array.Array.swap;

/**
 * QuickSort is a divide-and-conquer sorting algorithm that is efficient for large datasets. It picks a pivot, partitions the array around it, and recursively sorts the subarrays.
 */

/**
 * how the partition process works in Quick Sort, as it's the heart of the algorithm. I'll break it down step-by-step using the implementation from the previous example, where we use the last element as the pivot.
 * <p>
 * How Partition Works
 * The partition() method takes an array and rearranges it so that:
 * <p>
 * All elements less than or equal to the pivot are on the left side.
 * keep the element as where it is if current PI and I point to the same element
 * or swap the element with the big element the PI points to
 * All elements greater than the pivot are on the right side
 * The pivot ends up in its final sorted position
 */
public class QuickSort {

    public static void sort(int[] arr) {
        //start recursive method call from beginning.
        quickSort(arr, 0, arr.length - 1);
    }

    // Method to perform quick sort
    public static void quickSort(int[] arr, int left, int right) {
        //set return condition
        if (left >= right) return;

        //main process, and make smaller task
        int partitionIndex = partition(arr, left, right);

        // make smaller task, and recursively call method
        quickSort(arr, left, partitionIndex - 1);  //left array,
        quickSort(arr, partitionIndex + 1, right);
    }

    // main process,to put the pivotal element on to right position.
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int p = left; //partition index
        // single pass of the array for the range
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                if (i != p) {
                    swap(arr, i, p);
                }
                p++;
            }
        }
        //complete
        swap(arr, p, right);
        return p;
    }

    // client
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 90, 12, 22, 11, 90};
        System.out.println("Original array:" + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted array:" + Arrays.toString(arr));
    }
}
