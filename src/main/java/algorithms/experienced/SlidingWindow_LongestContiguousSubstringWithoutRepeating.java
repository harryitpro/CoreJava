package algorithms.experienced;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * for example: input: "abcabcbb". output: 3.   ("abc")
 */
public class SlidingWindow_LongestContiguousSubstringWithoutRepeating {
    /**
     * Hint:
     * SlidingWindow Solution:
     *
     * maintain a dynamic record of maxLength variable.
     * use Set<Character> to track duplicate;
     * maintain a Sliding Window:
     * (left index, right index), shrink(left increment), or expand(right increment) to track length.
     * update the Set to maintain satisfied condition.
     */
    static int solution(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();

        int maxLength = 0;

        int left = 0, N = s.length();
        Set<Character> set = new HashSet<>();
        Character c;
        for (int right = left; right < N; right++) {
            c = s.charAt(right);
            while (set.contains(c)) {
                //shrink window by increasing left pointer, adjust set accordingly
                set.remove(s.charAt(left));
                left++; //shrink window.
            }
            set.add(c);  //this char is unique
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("run solution: " + solution("abcabcbb")); //expected 3
    }
}
