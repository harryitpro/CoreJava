package algorithms.priorityqueue;

import java.util.List;

/**
 * You are given k sorted lists (or arrays), where each list contains integers in non-decreasing order. Your task is to merge these lists into a single sorted list.
 * Input:
 * list1 = [1, 4, 5]
 * list2 = [1, 3, 4]
 * list3 = [2, 6]
 * Output:
 * [1, 1, 2, 3, 4, 4, 5, 6]
 */
import java.util.*;

public class Heap_MergeKSortedLists {

    public static List<Integer> mergeSortedLists(List<List<Integer>> lists) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));

        // Step 1: Put the first element of each list into the heap
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.offer(new Element(lists.get(i).get(0), i, 0));
            }
        }

        // Step 2: Extract min and insert next element from the same list
        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            result.add(current.value);

            int nextIndex = current.elementIndex + 1;
            List<Integer> currentList = lists.get(current.listIndex);
            if (nextIndex < currentList.size()) {
                minHeap.offer(new Element(currentList.get(nextIndex), current.listIndex, nextIndex));
            }
        }

        return result;
    }

    // Helper class to keep track of value and origin
    private static class Element {
        int value;
        int listIndex;
        int elementIndex;

        Element(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> inputLists = Arrays.asList(
                Arrays.asList(1, 4, 7),
                Arrays.asList(2, 5, 8),
                Arrays.asList(3, 6, 9),
                Arrays.asList(0, 10, 11)
        );

        List<Integer> merged = mergeSortedLists(inputLists);
        System.out.println("Merged Sorted List: " + merged);
    }
}

