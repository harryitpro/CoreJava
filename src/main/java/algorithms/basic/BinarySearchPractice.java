package algorithms.basic;

public class BinarySearchPractice {
    //search sorted int array, return index or -1 if not found
    static int binarySearch(int[] arr, int key) {
        if ((arr == null) || arr.length == 0) {
            return -1;
        }
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] > key) { //key on left side
                right = mid - 1;
            } else { //key on right side
                left = mid + 1;
            }
        }
        return -1;
    }
}
