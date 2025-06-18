package algorithms.datasturctures.stack;

/**
 * implement Stack<Integer> using Array. Following LIFO
 * method:
 * push(): add one int
 * pop(): pop the top one. (remove)
 * peek(): return the top one without remove.
 */
class StackArray {
    private int capacity;
    private int[] stack;
    private int top;

    public StackArray(int size) {
        this.capacity = size;
        this.stack = new int[size];
        this.top = -1;
    }

    //O(1) time complexity
    public void push(int item) {
        if (isFull()) {
            throw new RuntimeException("Stack Overflow");
        }
        stack[++top] = item;
    }

    //O(1) time complexity
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }

    //O(1) time complexity
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}



