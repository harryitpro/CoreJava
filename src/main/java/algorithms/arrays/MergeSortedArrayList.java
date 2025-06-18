package algorithms.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArrayList {

    //merge K sorted array with a list.
    //solution: to use PriorityQueue for best performance: O(log(K)) run-time
    static List<Integer> mergeMultipleSortedArray(List<int[]> list) {
        List<Integer> result = new ArrayList<>();

        //very important
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (e1, e2) -> e1[0] - e2[0]
        );

        // init loop:
        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            if (arr != null && arr.length > 0) { // Add arr != null check
                int[] element = new int[]{arr[0], i, 0};
                minHeap.offer(element);
            }
        }

        while (!minHeap.isEmpty()) {
            int[] smallest = minHeap.poll();
            int value = smallest[0];
            int listIndex = smallest[1];
            int elementIndex = smallest[2];

            //start filling result:
            result.add(value);

            //update minHeap for nest loop
            int[] arr = list.get(listIndex);
            int nextElementIndex = elementIndex + 1;
            if (nextElementIndex < arr.length) {
                int[] element = new int[]{arr[nextElementIndex], listIndex, nextElementIndex};
                minHeap.offer(element);
            }
        }

        return result;
    }
}
