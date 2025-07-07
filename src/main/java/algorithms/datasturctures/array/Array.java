package algorithms.datasturctures.array;

import java.util.Arrays;

/**
 * Arrays factory methods.
 * Arrays.equals(arr1,arr2)
 * Arrays.toString() : list each element in string.
 * Arrays.sort()
 * Arrays.binarySearch()
 * Arrays.stream()
 * Arrays.copyOfRange(arr, i, i + k)
 */

public class Array {
    void initializeWithValues() {

        //Declare and Initialize in one
        char[] chars1 = new char[]{'a', 'b', 'c'};
        char[] chars2 = {'a', 'b', 'c'};

        //Declare and Initialize concise way
        int[] arr = {1, 2, 3, 4, 5};
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday"};

        //New
        int[] arrWithCapacity = new int[3];
        arrWithCapacity[0] = 1;
        arrWithCapacity[1] = 2;
        arrWithCapacity[2] = 3;
        //2 dimensions array.
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {2, 4, 6}
        };
    }

    static int[] getArrayFromVariables() {
        int a = 1, b = 2;
        return new int[]{a, b};
    }

    static void iterateThroughForStatement() {
        int[] array = {10, 20, 30};
        for (int i : array) {
            System.out.println(i);
        }
    }

    //Arrays.equals(arr1,arr2)
    static boolean equals(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    //swap method
    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
