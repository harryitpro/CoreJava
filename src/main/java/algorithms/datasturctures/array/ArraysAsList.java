package algorithms.datasturctures.array;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAsList {

    //the resulting list is backed by the array. which means update to the list will impact the array.
    static List<Integer> getListFromObjectArray(Integer[] arr) {
        System.out.println("Original Array value =  " + Arrays.toString(arr));

        //perform Arrays.asList();
        List<Integer> list = Arrays.asList(arr);
        //try update the resulting list
        arr[0] = 100;

        //verify the backed array --- the backend array has been changed
        System.out.println("after calling Arrays.asList(),  Array value =  " + Arrays.toString(arr));

        return list;
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        getListFromObjectArray(arr);
    }
}
