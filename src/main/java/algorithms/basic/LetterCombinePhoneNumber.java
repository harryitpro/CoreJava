package algorithms.basic;

import java.util.*;

public class LetterCombinePhoneNumber {
    public static List<String> letterCombinations(String digits) {
        //edge case
        if (digits == null || digits == "")
            return new ArrayList();

        //use an Character array to represent the digit to letter mapping. a list to contain all the mappings
        List<char[]> digitToLetters = new ArrayList<>();
        digitToLetters.add(new char[]{'a', 'b', 'c'}); //'2'
        digitToLetters.add(new char[]{'d', 'e', 'f'}); //'3'
        digitToLetters.add(new char[]{'g', 'h', 'i'}); //'4'
        digitToLetters.add(new char[]{'j', 'k', 'l'}); //'5'
        digitToLetters.add(new char[]{'m', 'n', 'o'}); //'6'
        digitToLetters.add(new char[]{'p', 'q', 'r', 's'}); //'7'
        digitToLetters.add(new char[]{'t', 'u', 'v'}); //'8'
        digitToLetters.add(new char[]{'w', 'x', 'y', 'z'}); //'9'

        //use Queue<StringBuilder> to contain current and final result.
        Queue<StringBuilder> queue = new ArrayDeque<>();
        for (char c : digits.toCharArray()) {
            int digitIndex = c - '2';
            char[] letters = digitToLetters.get(digitIndex);
            int letterNums = letters.length;
            if (queue.isEmpty()) {
                queue.offer(new StringBuilder());
            }

            //start parsing
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                StringBuilder preStr = queue.poll();
                for (int j = 0; j < letters.length; j++) {
                    StringBuilder currentStr = new StringBuilder();
                    currentStr.append(preStr).append(letters[j]);
                    queue.offer(currentStr);
                }
            }
        }

        //output result
        List<String> strings = new ArrayList<>();
        while (!queue.isEmpty()) {
            StringBuilder s = queue.poll();
            strings.add(s.toString());
        }
        return strings;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
