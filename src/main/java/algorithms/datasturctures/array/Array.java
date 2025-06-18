package algorithms.datasturctures.array;

import java.util.Arrays;

/**
 * Initialize with Values
 * array's equals.
 * with streams.
 */

/**
 * Arrays factory methods.
 * Arrays.equals(arr1,arr2)
 * Arrays.toString() : list each element in string.
 * Arrays.sort()
 * Arrays.binarySearch()
 * Arrays.asList()
 * Arrays.stream()
 * Arrays.copyOfRange(arr, i, i + k)
 */

public class Array {
    void initializeWithValues() {

        //Declare and Initialize in one
        char[] chars = new char[]{'a', 'b', 'c'};

        //Declare and Initialize concise way
        int[] arr = {1, 2, 3, 4, 5};
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday"};

        //New
        int[] arrWithCapacity = new int[3];
        arrWithCapacity[0] = 1;
        arrWithCapacity[1] = 2;
        arrWithCapacity[2] = 3;

        //2 -dimensional array. row/columns are inferred
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {2, 4, 6}
        };
    }

    static void checkEqual() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println("arr1 == arr2 : " + (arr1 == arr2));//false
        System.out.println("arr1.equals(arr2) : " + arr1.equals(arr2)); //false
        System.out.println("Arrays.equals(arr1,arr2) = " + equals(arr1, arr2)); //true
    }

    //index start from 0, the last index is length-1
    static void iterate() {
        int[] array = {10, 20, 30};
        Arrays.stream(array).forEach(i -> System.out.print(i + " ")); //10 20 30
    }

    static int sum(int[] array) {
        return Arrays.stream(array).sum(); //15
    }

    static int max(int[] arr) {
        return Arrays.stream(arr)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    static boolean equals(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    static int[] getArrayFromVariables(){
        int a = 1, b = 2;
        int[] result = {a, b};
        return result;
    }
    public static void main(String[] args) {
        int[] result = getArrayFromVariables();
        System.out.println(Arrays.toString(result));
    }
}
