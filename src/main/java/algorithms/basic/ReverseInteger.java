package algorithms.basic;

/**
 * use remainder of Mod operator
 * check the edge case of number overflow.
 */
public class ReverseInteger {
    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
}

