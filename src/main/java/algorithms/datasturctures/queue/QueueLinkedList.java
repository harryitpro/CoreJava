package algorithms.datasturctures.queue;

import algorithms.datasturctures.ListNode;

public class QueueLinkedList {
    private ListNode front, rear; //front for dequeue, rear for enqueue

    public void enqueue(int data) {
        if (isEmtpy())
            front = rear = new ListNode(data);
        else {
            rear.next = new ListNode(data);
            rear = rear.next;
        }
    }

    public int dequeue() {
        if (isEmtpy()) {
            throw new RuntimeException("empty queue");
        }
        ListNode listNode = front;
        front = front.next;
        return listNode.val;
    }

    public boolean isEmtpy() {
        return front == null;
    }

    // Display Queue
    public void display() {
        for (ListNode listNode = front; listNode != null; listNode = listNode.next) {
            System.out.println(listNode.val);
        }
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display(); // Output: 10 20 30

        queue.dequeue();
        queue.display(); // Output: 20 30
    }
}
