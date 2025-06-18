package algorithms.basic;

import static algorithms.basic.datasturctures.array.Array.swap;

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
}
