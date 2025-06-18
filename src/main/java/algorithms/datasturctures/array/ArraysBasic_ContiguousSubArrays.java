package algorithms.datasturctures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all contiguous sub-arrays of an array
 */
public class ArraysBasic_ContiguousSubArrays {
    static List<char[]> findAllContiguousSubArrays(char[] arr) {
        List<char[]> subArrays = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                subArrays.add(Arrays.copyOfRange(arr, i, j + 1));
            }
        }
        return subArrays;
    }

    //fixed size sub arrays
    static List<char[]> findAllContiguousSubArrays(char[] arr, int k) {
        if (k > arr.length) {
            throw new IllegalArgumentException("sub array size is bigger than original array size");
        }
        List<char[]> subArrays = new ArrayList<>();
        for (int i = 0; i + k - 1 <= arr.length - 1; i++) {
            subArrays.add(Arrays.copyOfRange(arr, i, i + k));
        }
        return subArrays;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd'};
        List<char[]> subs = findAllContiguousSubArrays(arr);
        for (char[] sub : subs)
            System.out.println(sub);
    }
}
