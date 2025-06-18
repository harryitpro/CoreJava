package algorithms.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    /**
     * Merges k sorted lists into a single sorted list.
     *
     * @param lists A list of sorted lists (each containing integers in non-decreasing order).
     * @return A new list containing all elements from the input lists, sorted in non-decreasing order.
     */
    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        // The result list that will store the merged elements
        List<Integer> mergedList = new ArrayList<>();

        // A min-priority queue to store elements from each list.
        // The elements in the priority queue will be arrays:
        // [value, listIndex, elementIndex]
        // value: the actual integer value
        // listIndex: the index of the list from which this value came
        // elementIndex: the index of this value within its original list
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Initialize the heap with the first element from each list
        // if the list is not empty.
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> currentList = lists.get(i);
            if (currentList != null && !currentList.isEmpty()) {
                minHeap.add(new int[]{currentList.get(0), i, 0});
            }
        }

        // Process elements from the heap until it's empty
        while (!minHeap.isEmpty()) {
            // Extract the smallest element
            int[] smallest = minHeap.poll();
            int value = smallest[0];
            int listIndex = smallest[1];
            int elementIndex = smallest[2];

            // Add the extracted element to our merged list
            mergedList.add(value);

            // If there are more elements in the list from which we just extracted,
            // add the next element to the heap.
            List<Integer> currentList = lists.get(listIndex);
            if (elementIndex + 1 < currentList.size()) {
                minHeap.add(new int[]{currentList.get(elementIndex + 1), listIndex, elementIndex + 1});
            }
        }

        return mergedList;
    }

}