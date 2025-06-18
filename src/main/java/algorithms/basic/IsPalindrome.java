package algorithms.basic;

public class IsPalindrome {
    /**
     * @param s: string.
     * @return: whether the given string is a palindrome string.
     */
    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
