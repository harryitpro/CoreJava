package algorithms.basic;

import algorithms.datasturctures.ListNode;

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedListNode {
    public ListNode mergeKLists(ListNode[] lists) {
        //use PriorityQueue<ListNode> to maintain K elements, keep getting the minimal one.
        ListNode root = null;
        ListNode current = null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((e1, e2) -> e1.val - e2.val);
        for (int i = 0; i < lists.length; i++) {
            ListNode rootNode = lists[i];
            if (rootNode != null) {
                minHeap.offer(rootNode);
            }
        }
        if (!minHeap.isEmpty()) {
            root = minHeap.poll();
            current = root;
        }
        while (!minHeap.isEmpty()) {
            if (current.next != null) {
                minHeap.offer(current.next);
            }
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;
        }
        return root;
    }
}
