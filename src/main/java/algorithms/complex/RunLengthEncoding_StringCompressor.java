package algorithms.complex;

/**
 * RunLengthEncoding
 * Run-Length Encoding (RLE) is a simple compression algorithm that replaces consecutive repeated characters (or values) with a single character and its count.
 */
public class RunLengthEncoding_StringCompressor {
    static String solution(String s) {
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            compressed.append(c);

            //count repeated, start from zero.
            int count = 0;
            while (i < s.length() && s.charAt(i) == c) {
                i++;
                count++;
            }

            compressed.append(count);
        }
        return compressed.toString();
    }

    public String compress(String s) {
        // Handle null and empty string
        if (s == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        if (s.isEmpty()) {
            return "";
        }

        // Pre-allocate StringBuilder capacity
        StringBuilder compressed = new StringBuilder(s.length());
        char currentChar = s.charAt(0);
        int count = 1;

        // Iterate through the string
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == currentChar) {
                count++;
            } else {
                compressed.append(currentChar).append(count);
                currentChar = c;
                count = 1;
            }
        }

        // Append the last run
        compressed.append(currentChar).append(count);

        return compressed.toString();
    }

    public static void main(String[] args) {
        RunLengthEncoding_StringCompressor compressor = new RunLengthEncoding_StringCompressor();
        String[] testCases = {
                "aaabbbbbccd",  // a3b5c2d1
                "a",            // a1
                "abcd",         // a1b1c1d1
                "",             // ""
                "aaa"           // a3
        };

        for (String test : testCases) {
            System.out.println("Input: " + test + " → Compressed: " + compressor.compress(test));
        }
    }
}
