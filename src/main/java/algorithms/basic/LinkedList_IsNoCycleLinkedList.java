package algorithms.basic;

/**
 * Given a linked list, determine whether it contains a cycle (i.e., a node's next pointer eventually points back to a previous node).
 * 1 → 2 → 3 → 4 → 5
 * ↑         ↓
 * 8 ← 7 ← 6
 */

import algorithms.datasturctures.Node;

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
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next; // Cycle at node 3

        System.out.println(hasCycle(head)); // Output: true
    }
}


