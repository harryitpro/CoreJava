package algorithms.complex;

public class StringBuilder_ReverseInteger {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;  // Get last digit
            rev = rev * 10 + digit;  //build reverse number
            x /= 10;             // Remove last digit from x
        }
        return rev;
    }

    static int reverseByStringBuilder(int num) {
        int sign = 1;
        String target;
        if (num < 0) {
            sign = -1;
            target = String.valueOf(num).substring(1);
        } else {
            target = String.valueOf(num);
        }
        StringBuilder stringBuilder = new StringBuilder(target);
        return Integer.parseInt(stringBuilder.reverse().toString()) * sign;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123)); //321
        System.out.println(reverse(-123)); //-321

        System.out.println(reverseByStringBuilder(-123)); //
    }
}
