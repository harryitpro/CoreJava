package algorithms.datasturctures.stack;

import algorithms.datasturctures.ListNode;

class StackLinkedList {
    private ListNode top;

    public StackLinkedList() {
        this.top = null;
    }

    //O(1) time complexity
    //replace top pointer to the new Node, keep existing top as tmp.
    public void push(int data) {
        ListNode tmp = top;
        top = new ListNode(data);
        top.next = tmp;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.val;
    }

    //O(1) time complexity
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        ListNode tmp = top;
        top = top.next;
        return tmp.val;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

