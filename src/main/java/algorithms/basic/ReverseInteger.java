package algorithms.basic;

public class ReverseInteger {
    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            long remain = x % 10;
            result = result * 10 + remain;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
    }
}

