package algorithms.basic;

/**
 * given a sorted array of integers and a key value, return the first index of searching result, and -1 if not found
 * condition: array does not contain duplicated numbers.
 */
public class BinarySearchFirstOccurrence {

    //what about sorted array contains duplicated keys?
    public static int searchFirstOccurrence(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left < right) { //stop when left converge with right index!!!!
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) { //found key.
                //continue searching to the left
                right = mid; //including this position for following search
            } else if (arr[mid] < key) {//not found on left, go to right side
                left = mid + 1;
            } else { //not found on right, go to left
                right = mid - 1;
            }
        }
        if (arr[left] == key) return left;
        else return -1;
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 3, 3, 4, 5, 6, 8};
        System.out.println(searchFirstOccurrence(arr, 3));  //expecting 3
        System.out.println(searchFirstOccurrence(arr, 4));  //expecting 6
        System.out.println(searchFirstOccurrence(arr, 7));  //expecting -1
    }
}
