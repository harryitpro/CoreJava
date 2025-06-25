package algorithms.basic;

import java.util.*;

/**
 * Question: Given an integer n, generate all valid combinations of n pairs of parentheses.
 * <p>
 * Example: Input: n=3 → Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParentheses {
    public static Character open = '(', close = ')';
    public static List<Character> charSet = List.of(open, close);

    public static List<String> generateParenthesis(int n) {
        int openCount = 0, closeCount = 0, length = n;
        List<String> result = new ArrayList<>();
        StringBuilder ancestor = new StringBuilder();
        generateParenthesis(ancestor, length, openCount, closeCount, result);
        return result;
    }

    static void generateParenthesis(StringBuilder ancestor, int length, int openCount, int closeCount, List<String> result) {
        if (closeCount > openCount) { //invalid
            return;
        }
        if (openCount > length || closeCount > length) {
            return;
        }
        if (ancestor.length() == length * 2) {
            result.add(ancestor.toString());
            return;
        }
        //start parsing, 2 scenarios: append left/append right
        for (int i = 0; i < charSet.size(); i++) {
            StringBuilder newAncestor = new StringBuilder(ancestor);
            Character ch = charSet.get(i);
            newAncestor.append(ch);
            if (ch == open) {
                generateParenthesis(newAncestor, length, openCount + 1, closeCount, result);
            } else {
                generateParenthesis(newAncestor, length, openCount, closeCount + 1, result);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
