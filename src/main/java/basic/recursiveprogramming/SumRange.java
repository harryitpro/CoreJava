package basic.recursiveprogramming;

/**
 * *  a method call chain with smaller scope of input
 * *  unwind till the certain returning condition is met.
 * * how to get the recursive solution?
 * 1, Can this question be split to a small scoped question, with the same solution. -- YES
 * IF YES: how to establish the input, to decide:
 * *** Returning Condition
 * *** Decrease the scope
 * END IF
 */
public class SumRange {
    /**
     * a recursive method.
     * each call will make a smaller scope by increasing from by from++
     * returning condition: from == to
     */
    static int sumRange_head(int from, int to) {
        if (to == from)
            return to;
        return from + sumRange_head(++from, to);
    }

    static int sumRange_tail(int from, int to) {
        if (to == from)
            return to;
        int sum = to + sumRange_tail(from, --to);
        return sum;
    }

    static int sumRange_middle(int from, int to) {
        if (to == from)
            return to;
        int middle = from + (to - from) / 2;
        int sumLeft = sumRange_middle(from, middle);
        int sumRight = sumRange_middle(middle + 1, to);
        int sum = sumLeft + sumRight;
        return sum;
    }

    /**
     * sum from 1 to the number input
     *
     * @param to: the last number
     * @return sum result.
     */
    static int sumTo(int to) {
        if (to == 1) return 1;
        int sum = to + sumTo(--to);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumRange_head(1, 10)); //expect 5050
        System.out.println(sumRange_tail(1, 10)); //expect 5050
        System.out.println(sumRange_middle(1, 10)); //expect 5050
        System.out.println(sumTo(10));
    }
}
