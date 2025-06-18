package algorithms.basic;

/**
 * The approach used here is the "Expand Around Center" method, which is a common and efficient way to solve this problem.
 */
public class LongestPalindrome {
    static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return ""; // An empty string is the longest palindrome of an empty string
        }

        int[] maxLength = new int[]{-1, -1, 0};  //[left_index,right_index,length]
        for (int i = 0; i < s.length(); i++) {
            int[] oddPalindrome = palindrome(s, i, i);
            int[] evenPalindromeLength = palindrome(s, i, i + 1);
            int[] current = oddPalindrome[2] >= evenPalindromeLength[2] ? oddPalindrome : evenPalindromeLength;
            if (current[2] > maxLength[2]) {
                maxLength = current;
            }
        }
        return s.substring(maxLength[0], maxLength[1] + 1);
    }

    static int[] palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //important: adjust the final left and right value
        return new int[]{++left, --right, right - left + 1};
    }

    public static void main(String[] args) {
        String s = "abbad";
        System.out.println(longestPalindrome(s));
    }
}
