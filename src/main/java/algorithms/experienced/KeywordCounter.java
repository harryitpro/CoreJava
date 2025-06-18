package algorithms.experienced;

import java.util.Arrays;

/**
 * To count occurrences of a keyword in an article (text)
 * return counter
 */
public class KeywordCounter {
    private static String nonWordExpression = "\\W+";
    private String str = "";
    /**
     * Uses regular expressions (\W+ or \b\w+\b) to split text into words.
     * Case-insensitive comparison (equalsIgnoreCase(), ignoreCase = true, .lower()).
     */
    public static int countKeyword(String article, String key) {
        String[] words = article.split(nonWordExpression);
        return (int) Arrays.stream(words).filter(word -> word.equalsIgnoreCase(key)).count();
    }

    public int indexOf(String searchKeyword, int fromIndex) {
        if (searchKeyword == null) {
            throw new NullPointerException("Search string cannot be null");
        }

        // Get character arrays (in real Java, this.value is the char[] backing the String)
        char[] source = str.toCharArray();  // The string we're searching in
        char[] target = searchKeyword.toCharArray();  // The string we're searching for

        int sourceLength = source.length;
        int targetLength = target.length;

        // Handle edge cases
        if (fromIndex >= sourceLength) {
            return (targetLength == 0 ? sourceLength : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetLength == 0) {
            return fromIndex;
        }

        // Optimization: if remaining length is less than target, no match possible
        if (sourceLength - fromIndex < targetLength) {
            return -1;
        }

        char first = target[0];  // First character of search string
        int max = sourceLength - targetLength;  // Last possible starting position

        // Main search loop
        for (int i = fromIndex; i <= max; i++) {
            // Look for first character
            if (source[i] == first) {
                // Found first character, check rest of the string
                int j = 1;
                while (j < targetLength && source[i + j] == target[j]) {
                    j++;
                }
                // If we matched all characters
                if (j == targetLength) {
                    return i;  // Return starting position
                }
            }
        }
        return -1;  // No match found
    }

    public static void main(String[] args) {
        String article = "This is a practice string of abc abc and cba, count how many abcs inside it";
        System.out.println(countKeyword(article, "ABC"));  //expecting 2
    }
}
