package algorithms.basic;

import java.util.*;

public class FibonacciSequence {
    static int[] fib(int n) {
        int[] fibs = new int[n + 1];
        Arrays.fill(fibs, -1);
        fib(n, fibs);
        return fibs;
    }

    private static int fib(int n, int[] fibs) {
        if (fibs[n] != -1) return fibs[n];

        if (n == 0 || n == 1) {
            fibs[n] = n;
            return fibs[n];
        }

        long finNMinusTwo = fib(n - 2, fibs);
        long finNMinusOne = fib(n - 1, fibs);

        long result = finNMinusTwo + finNMinusOne;
        if (result > Integer.MAX_VALUE) {
            System.out.println("overflow");
            return -1;
        }
        fibs[n] = (int) result;
        return fibs[n];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fib(25)));
    }
}
