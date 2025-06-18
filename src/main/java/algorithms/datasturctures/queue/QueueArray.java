package algorithms.datasturctures.queue;

/**
 * Queue:
 * quick first in, first out.
 * a Linear data storage structure, relationship between elements is previous/next
 * operation: insert, delete,search.
 */
class QueueArray {
    private int[] queue;
    private int capacity;
    private int front, rear;
    private int size;  // verify whether a queue is full or empty

    public QueueArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    //O(1) time complexity
    public void enqueue(int data) {
        if (isFull()) {
            throw new RuntimeException("Queue Overflow");
        }
        rear = (++rear) % capacity; // Circular increment, to re-use space from front.
        queue[rear] = data;
        size++;
    }

    //O(1) time complexity
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }
        int data = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        return data;
    }

    // Display Queue
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display(); // Output: Queue: 10 20 30

        queue.dequeue();
        queue.display(); // Output: Queue: 20 30
    }
}

