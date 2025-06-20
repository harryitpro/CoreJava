package algorithms.basic;

/**
 * given a String, verify whether it's a palindrome
 */
public class IsPalindromeLetterOrDigit {
    static boolean isPalindromeIgnoreNonLetterOrDigi(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
