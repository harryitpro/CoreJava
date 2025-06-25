package algorithms.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneNumberLettersBacktrack {
    static Map<Character, List<Character>> digitToLetters = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );

    public static List<String> letterCombinations(String digits) {
        List<String> allCombines = new ArrayList<>();
        StringBuilder root = new StringBuilder();
        int startIndex = 0;
        combineDigitLetters(digits, startIndex, root, allCombines);
        return allCombines;
    }

    static void combineDigitLetters(String digits, int startIndex, StringBuilder ancestor, List<String> allCombines) {
        if (ancestor.length() == digits.length()) {
            allCombines.add(ancestor.toString());
            return;
        }
        for (int i = startIndex; i < digits.length(); i++) {
            List<Character> characters = digitToLetters.get(digits.charAt(i));
            if (characters == null) {
                continue;
            }
            for (char c : characters) {
                StringBuilder newAncestor = new StringBuilder(ancestor).append(c);
                combineDigitLetters(digits, i + 1, newAncestor, allCombines);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
