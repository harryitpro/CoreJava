package algorithms.basic;

/**
 * key approach to integer reverse:
 * use integer's Mod operator to get remain
 * use divide operator to get result value
 * check the boundary of Integer.MAX_VALUE and Integer.MIN_VALUE
 * ues long data type in case of overflow
 * convert back to int if asked
 */
public class isPalindromeInteger {
    boolean isPalindrome(int num) {
        if (num < 0) return false;
        //reverse num, to check whether reversed is equal to original
        int original = num;
        long reverseNum = 0;
        while (num != 0) {
            reverseNum = reverseNum * 10 + num % 10;
            if (reverseNum > Integer.MAX_VALUE) return false;
            num = num / 10;
        }
        if (reverseNum == original) return true;
        return false;
    }
}
