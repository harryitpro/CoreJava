package basic.recursiveprogramming;

import algorithms.datasturctures.Node;

public class ReverseLinkedList {
    static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //testing
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node newHead = reverse(head);
        
        for (Node node = newHead; node != null; node = node.next) {
            System.out.println(node.val);
        }
    }
}
