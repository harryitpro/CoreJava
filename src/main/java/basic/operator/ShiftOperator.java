package basic.operator;

/**
 * How it works?
 */
public class ShiftOperator {
    static void shiftRight() {
        int n = 10;
        System.out.println(n >> 2); // shift to right side 2 times
    }

    public static void main(String[] args) {
        shiftRight();
    }
}
