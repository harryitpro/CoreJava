package algorithms.basic;

public class StringRotationCheck {
    // Method to check if str1 is a substring of str2
    private static boolean isSubstring(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false;
        }

        for (int i = 0; i <= str2.length() - str1.length(); i++) {
            boolean match = true;

            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) != str2.charAt(i + j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return true;
            }
        }

        return false;
    }

    // Method to check if str1 is a rotation of str2
    public static boolean isRotation(String str1, String str2) {
        // Check if both strings have the same length and are not empty
        if (str1.length() != str2.length() || str1.length() == 0) {
            return false;
        }

        // Concatenate str2 with itself
        String concatenated = str2 + str2;

        // Check if str1 is a substring of concatenated str2
        return isSubstring(str1, concatenated);
    }

    public static void main(String[] args) {
        // Test cases
        String[][] tests = {
                {"abc", "cab"},
                {"hello", "llohe"},
                {"water", "terwa"},
                {"abc", "def"},
                {"", ""},
                {"a", "a"}
        };

        for (String[] test : tests) {
            String str1 = test[0];
            String str2 = test[1];
            System.out.println("Is \"" + str1 + "\" a rotation of \"" + str2 + "\"? " +
                    isRotation(str1, str2));
        }
    }
}
