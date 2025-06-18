package algorithms.datasturctures.heap;

import java.util.Arrays;

public class MinHeap {
    private int[] heap; // Array to store heap elements
    private int size;   // Current number of elements in the heap
    private int capacity; // Maximum capacity of the heap

    // Constructor
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Get the index of the parent of a node
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Get the index of the left child of a node
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Get the index of the right child of a node
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Swap two elements in the heap array
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Insert a new element into the heap
    public void insert(int value) {
        if (size >= capacity) {
            throw new IllegalStateException("Heap is full");
        }

        // Add the new element at the end
        heap[size] = value;
        size++;

        // Fix the heap property by bubbling up the new element
        bubbleUp(size - 1);
    }

    // Bubble up the element at the given index to maintain the heap property
    private void bubbleUp(int index) {
        while (index > 0 && heap[parent(index)] > heap[index]) {
            // Swap with parent if parent is greater (violates Min-Heap property)
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Extract the minimum element (root) from the heap
    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        // Store the minimum value (root) to return
        int min = heap[0];

        // Move the last element to the root and reduce size
        heap[0] = heap[size - 1];
        size--;

        // Fix the heap property by bubbling down the root
        if (size > 0) {
            bubbleDown(0);
        }

        return min;
    }

    // Bubble down the element at the given index to maintain the heap property
    private void bubbleDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        // Compare with left child
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        // Compare with right child
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        // If the smallest is not the current node, swap and continue bubbling down
        if (smallest != index) {
            swap(index, smallest);
            bubbleDown(smallest);
        }
    }

    // Peek at the minimum element without removing it
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the current size of the heap
    public int size() {
        return size;
    }

    // For debugging: Print the heap array
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(heap, 0, size));
    }

    // Main method to test the MinHeap implementation
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        // Insert some elements
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(10);

        System.out.println("Heap: " + minHeap); // Should print: [1, 3, 8, 5, 10]
        System.out.println("Min element: " + minHeap.peek()); // Should print: 1

        // Extract minimum elements one by one
        while (!minHeap.isEmpty()) {
            System.out.println("Extracted min: " + minHeap.extractMin());
            System.out.println("Heap after extraction: " + minHeap);
        }
    }
}
