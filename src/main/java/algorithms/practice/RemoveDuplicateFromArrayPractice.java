package algorithms.practice;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of characters, remove all duplicate characters while maintaining the original order of first occurrence or producing a new array with unique characters. For example, input ['a', 'b', 'a', 'c', 'b'] should result in ['a', 'b', 'c'].
 */
public class RemoveDuplicateFromArrayPractice {
    public static char[] removeDuplicate(char[] chars) {
        LinkedHashSet<Character> charSet = new LinkedHashSet<>();
        for (char c : chars) {
            charSet.add(c);
        }
        char[] result = new char[charSet.size()];
        int i = 0;
        for (char c : charSet) {
            result[i++] = c;
        }
        return result;
    }

    public static char[] removeDuplicateThroughStream(char[] chars) {
        //get list
        List<Character> uniqueChars =
                String.valueOf(chars).chars()
                        .distinct()
                        .mapToObj(ch -> (char) ch)
                        .collect(Collectors.toUnmodifiableList());
        //convert list to array
        char[] charArray = new char[uniqueChars.size()];
        int i = 0;
        for (Character ch : uniqueChars) {
            charArray[i++] = ch;
        }
        return charArray;
    }
}
