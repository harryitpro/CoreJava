package algorithms.basic;

public class BinarySearch {
    /**
     * @param arr: ordered array.
     * @param key: search key.
     * @return  the index of the index, or -1 if not found.
     */
    static int binarySearch(int[] arr, int key) {
        //return Arrays.binarySearch(arr,key);
        int left = 0, right = arr.length - 1;
        while (left <= right) { //must be "<="
            int mid = left + (right - left) / 2;
            if (key == arr[mid]) return mid;
            else if (key < arr[mid]) right = --mid;
            else ++left;
        }
        return -1;
    }
}

