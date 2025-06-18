package algorithms.complex;

import java.util.Arrays;
import java.util.Stack;

/**
 * The Next Greater Element (NGE) problem is a super popular stack-based interview question
 * Problem Statement
 * Given an array arr[] of integers, for each element, find the next greater element to its right.
 * If there is no greater element, return -1 for that index.
 */
public class Stack_NextGreaterElementStack {
    /**
     * Efficient Approach: Using Stack (O(n) time)
     * Traverse the array from right to left
     *
     * Use a monotonic stack (decreasing) to keep track of potential NGEs
     *
     * For each element, pop smaller elements, then peek the next greater one
     */
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Remove smaller elements from stack
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // Assign next greater element
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element onto stack
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println("Next Greater Elements: " + Arrays.toString(nextGreaterElement(arr)));
        // Output: [5, 10, 10, -1, -1]
    }
}

