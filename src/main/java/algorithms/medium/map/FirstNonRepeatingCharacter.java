package algorithms.medium.map;

import java.util.LinkedHashMap;

/**
 * Problem: Find the first character in a string that appears only once.
 * <p>
 * Approach: Use a LinkedHashMap<Character, Integer> (to preserve insertion order) or two passes with a HashMap. First pass: count frequencies. Second pass: iterate through the string/LinkedHashMap and find the first character with count 1.
 * <p>
 * Example: "abacaba" -> 'c'
 */
public class FirstNonRepeatingCharacter {
    static char findFirstUniqueChar(String s) {
        LinkedHashMap<Character, Integer> charToCount = new LinkedHashMap<>();
        return 1;
    }
}
