package algorithms.experienced;

import java.util.ArrayList;
import java.util.List;

public class OfPermutations {
    static List<String> ofPermutations(String s) {

        if (s.isEmpty()) {
            throw new RuntimeException("string is empty");
        }

        List<String> result = new ArrayList<>();

        // Base case: return the String into the result when only one letter string
        if (s.length() == 1) {
            result.add(s);
            return result;
        }

        char firstChar = s.charAt(0); // Extract first character
        String remaining = s.substring(1); // Get remaining substring

        // Recursively get permutations of the remaining string
        List<String> smallerPermutations = ofPermutations(remaining);

        // Insert firstChar into every position of each smaller permutation
        for (String perm : smallerPermutations) {
            for (int i = 0; i <= perm.length(); i++) {
                String newPerm = perm.substring(0, i) + firstChar + perm.substring(i);
                result.add(newPerm);
            }
        }

        return result;
    }
}
