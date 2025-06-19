package algorithms.medium.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharacterFrequencies {
    static Map<Character, Integer> countCharacterFrequency(String s) {
        Map<Character, Integer> characterToFrequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            characterToFrequencyMap.put(c, characterToFrequencyMap.getOrDefault(c, 0) + 1);
        }
        return characterToFrequencyMap;
    }

    public static Map<Character, Long> getCharFrequency(String s) {
        if (s == null || s.isEmpty()) {
            return Map.of(); // Returns an empty immutable map for null or empty string
        }

        return s.chars() // Returns an IntStream of character ASCII values
                .mapToObj(c -> (char) c) // Convert int ASCII to Character object
                .collect(Collectors.groupingBy(
                        Function.identity(), // Group by the character itself
                        Collectors.counting() // Count occurrences of each character
                ));
    }

}
