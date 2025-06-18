package algorithms.complex;

import java.util.List;
import java.util.Stack;

public class Stack_DecompressString {

    public static String decompress(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the repeat count (handle multi-digit numbers)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current state onto stacks
                countStack.push(k);
                strStack.push(current);
                // Reset for the inner pattern
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // End of current pattern, pop and build
                StringBuilder decoded = strStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decoded.append(current);
                }
                current = decoded;
            } else {
                // Normal character, just append
                current.append(ch);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        List<String> compressedList = List.of(
                "abc",
                "2[a]3[bc]",
                "2[a3[bc]]"
        );
        compressedList.stream()
                .map(str -> decompress(str))
                .forEach(System.out::println);
        /**
         * output:
         abc
         aabcbcbc
         abcbcbcabcbcbc
         */
    }
}

