package algorithms.basic;

public class LongestCommonSubsequence {

    /**
     * Calculates the length of the Longest Common Subsequence (LCS)
     * between two input strings.
     *
     * @param text1 The first input string.
     * @param text2 The second input string.
     * @return The length of the longest common subsequence.
     */
    public int calculateLcsLength(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        // dpTable[i][j] will store the length of the LCS
        // of text1[0...i-1] and text2[0...j-1].
        // The table size is (length1 + 1) x (length2 + 1) to handle empty prefixes.
        int[][] dpTable = new int[length1 + 1][length2 + 1];

        // Fill the dpTable using a bottom-up approach
        // i iterates through characters of text1 (1-indexed for dpTable)
        // j iterates through characters of text2 (1-indexed for dpTable)
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                // If the current characters match
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Extend the LCS from the diagonal element (LCS of previous prefixes) by 1
                    dpTable[i][j] = 1 + dpTable[i - 1][j - 1];
                } else {
                    // If characters do not match, take the maximum LCS from:
                    // 1. LCS of text1[0...i-2] and text2[0...j-1] (ignoring text1[i-1])
                    // 2. LCS of text1[0...i-1] and text2[0...j-2] (ignoring text2[j-1])
                    dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i][j - 1]);
                }
            }
        }

        // The length of the LCS of the entire strings is at the bottom-right corner
        return dpTable[length1][length2];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcsSolver = new LongestCommonSubsequence();

        String s4_1 = "ABC";
        String s4_2 = "ACB";
        System.out.println("LCS of \"" + s4_1 + "\" and \"" + s4_2 + "\": " + lcsSolver.calculateLcsLength(s4_1, s4_2)); // Expected: 2 ("AB" or "AC")


//
//        // Test Cases
//        String s1_1 = "AGGTAB";
//        String s1_2 = "GXTXAYB";
//        System.out.println("LCS of \"" + s1_1 + "\" and \"" + s1_2 + "\": " + lcsSolver.calculateLcsLength(s1_1, s1_2)); // Expected: 4 ("GTAB")
//
//        String s2_1 = "ABCDGH";
//        String s2_2 = "AEDFHR";
//        System.out.println("LCS of \"" + s2_1 + "\" and \"" + s2_2 + "\": " + lcsSolver.calculateLcsLength(s2_1, s2_2)); // Expected: 3 ("ADH")
//
//        String s3_1 = "ABC";
//        String s3_2 = "ABC";
//        System.out.println("LCS of \"" + s3_1 + "\" and \"" + s3_2 + "\": " + lcsSolver.calculateLcsLength(s3_1, s3_2)); // Expected: 3 ("ABC")
//
//
//
//        String s5_1 = "ABC";
//        String s5_2 = "DEF";
//        System.out.println("LCS of \"" + s5_1 + "\" and \"" + s5_2 + "\": " + lcsSolver.calculateLcsLength(s5_1, s5_2)); // Expected: 0 ("")
//
//        String s6_1 = "";
//        String s6_2 = "XYZ";
//        System.out.println("LCS of \"" + s6_1 + "\" and \"" + s6_2 + "\": " + lcsSolver.calculateLcsLength(s6_1, s6_2)); // Expected: 0 ("")
    }
}
