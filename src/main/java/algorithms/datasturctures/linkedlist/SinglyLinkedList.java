package algorithms.datasturctures.linkedlist;

import algorithms.datasturctures.ListNode;

/**
 * implement SinglyLinkedList.
 * term:
 * head: the first node of the list.
 * tail: if needed, it's the last node in the list. tail.next == null
 */
public class SinglyLinkedList {
    private ListNode head;

    public ListNode insert(int data) {
        if (head == null) {
            head = new ListNode(data);
            return head;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(data);

        return head;
    }

    // Delete a node by value
    public void delete(int key) {
        if (head == null) return;

        // If the head needs to be deleted
        if (head.val == key) {
            head = head.next;
            return;
        }

        //find the previous node of the node to be deleted,update the pointer to skip node_to_be_deleted
        ListNode prev = head;
        while (prev.next != null && prev.next.val != key) prev = prev.next;

        //update pointer.
        if (prev.next != null) prev.next = prev.next.next;
    }

    // traverse
    public void iterate() {
        for (ListNode listNode = head; listNode != null; listNode = listNode.next) {
            System.out.print(listNode.val + " -> ");
        }
        System.out.println("null");
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null, current = head, next;
        while (current != null) {//loop stops till current is null
            next = current.next;  //keep next reference
            current.next = prev; //process reverse
            prev = current; //move on

            current = next; //update current index
        }
        return prev;
    }

    static ListNode ofArray(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

}


