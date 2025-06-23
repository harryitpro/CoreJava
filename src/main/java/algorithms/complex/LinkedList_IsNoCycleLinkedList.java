package algorithms.complex;

/**
 * Given a linked list, determine whether it contains a cycle (i.e., a node's next pointer eventually points back to a previous node).
 * 1 → 2 → 3 → 4 → 5
 * ↑         ↓
 * 8 ← 7 ← 6
 */

import algorithms.datasturctures.ListNode;

/**
 * approach: Floyd’s Cycle Detection Algorithm
 * How It Works
 * Use two pointers:
 * Slow pointer (slow) moves one step at a time.
 * Fast pointer (fast) moves two steps at a time.
 * If there is a cycle, the fast pointer will eventually meet the slow pointer.
 * If fast reaches null, there is no cycle.
 */

public class LinkedList_IsNoCycleLinkedList {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move one step
            fast = fast.next.next;     // Move two steps

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next; // Cycle at node 3

        System.out.println(hasCycle(head)); // Output: true
    }
}


