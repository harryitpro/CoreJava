package algorithms.datasturctures.map;

import java.util.*;

public class MapFrequencyCounter {
    //for primitive character, there is no class like IntStream.
    public static Map<Character, Integer> toFreqMap(char[] arr) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : arr) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }

    public static Map<Integer, Integer> toFreqMap(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        Arrays.stream(arr).forEach(i -> freq.put(i, freq.getOrDefault(i, 0) + 1));
        return freq;
    }

    public static Map<String, Integer> toFreqMap(String[] arr) {
        Map<String, Integer> freq = new HashMap<>();
        Arrays.stream(arr).forEach(s -> freq.put(s, freq.getOrDefault(s, 0) + 1));
        return freq;
    }

    //apply to ASCII characters
    public static int[] toFreqArray(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c] = freq[c] + 1;
        }
        return freq;
    }

    public static Set<Integer> toSet(int[] arr) {
        Set<Integer> numberSet = new HashSet<>();
        Arrays.stream(arr).forEach(numberSet::add);
        return numberSet;
    }

    static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> sortedMap.put(e.getKey(), e.getValue()));

        return sortedMap;
    }



    public static void main(String[] args) {
        String s = "unique_string";
        Map<Character, Integer> charFreq = toFreqMap(s.toCharArray());
        Map.Entry<Character, Integer> largestEntry =
                charFreq.entrySet().stream()
                        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                        .findFirst()
                        .orElse(null);
        System.out.println(largestEntry == null ? null : largestEntry.getKey() + " : " + largestEntry.getValue());
    }

}
