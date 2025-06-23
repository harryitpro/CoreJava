package fundamental.recursiveprogramming;

import algorithms.datasturctures.ListNode;

public class ReverseLinkedList {
    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //testing
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode newHead = reverse(head);
        
        for (ListNode listNode = newHead; listNode != null; listNode = listNode.next) {
            System.out.println(listNode.val);
        }
    }
}
