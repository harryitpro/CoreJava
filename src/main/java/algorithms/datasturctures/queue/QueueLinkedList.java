package algorithms.datasturctures.queue;

import algorithms.datasturctures.Node;

public class QueueLinkedList {
    private Node front, rear; //front for dequeue, rear for enqueue

    public void enqueue(int data) {
        if (isEmtpy())
            front = rear = new Node(data);
        else {
            rear.next = new Node(data);
            rear = rear.next;
        }
    }

    public int dequeue() {
        if (isEmtpy()) {
            throw new RuntimeException("empty queue");
        }
        Node node = front;
        front = front.next;
        return node.val;
    }

    public boolean isEmtpy() {
        return front == null;
    }

    // Display Queue
    public void display() {
        for (Node node = front; node != null; node = node.next) {
            System.out.println(node.val);
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
