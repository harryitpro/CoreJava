package algorithms.basic;

//Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

/**
 * key:
 * int digit = s.charAt(i) - '0';  convert from character to get 10-based digit value
 * pay attention to boundary
 */
public class StringToInteger {
    int toInteger(String s) {
        int i = 0;
        //remove leading empty space
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) return 0;
        //get sign of String
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        if (i == s.length()) return 0;
        //get digit and calculation
        long result = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int) (sign * result);
    }
}
