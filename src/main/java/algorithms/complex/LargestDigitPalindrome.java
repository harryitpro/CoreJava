package algorithms.complex;

import java.util.*;

public class LargestDigitPalindrome {
    public static String solution(String S) {
        //build frequency map for digit.
        //go through from 9-1 to build the biggest palindrome for digit >=2 for the outer: build ///left and right string builder.
        //update the frequency value
        //put the max single digit to the middle of the palindrom

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : S.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }


        StringBuilder left = new StringBuilder();
        int max = -1;
           for (int i = 9; i >= 0; i--) {
            if (freq.containsKey(i)) {
                int count = freq.get(i);
                while (count >= 2) {
                    left.append(i);
                    count = count - 2;
                }
                if (count == 1) {
                    max = Math.max(max, i);
                }
            }
        }
        if (!left.toString().isEmpty()) {
            if (left.charAt(0) == '0') {
                return Math.max(max, 0)+"";
            }
            String right = left.reverse().toString();
            if (max != -1) {
                return left.append(max).append(right).toString();
            } else {
                return left.append(right).toString();
            }
        } else {
            return Math.max(max, 0)+"";
        }

    }


    public static void main(String[] args) {
        System.out.println(solution("39878"));
    }
}
