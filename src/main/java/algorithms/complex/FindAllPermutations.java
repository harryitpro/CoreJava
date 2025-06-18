package algorithms.complex;

import java.util.Arrays;

public class FindAllPermutations {
    public static void generatePermutations(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars); // Step 1: Sort initially
        System.out.println(new String(chars));

        while (true) {
            int i = chars.length - 2;

            // Step 2: Find rightmost char that is smaller than its next
            while (i >= 0 && chars[i] >= chars[i + 1]) {
                i--;
            }

            // If no such character is found, we are done
            if (i < 0) {
                break;
            }

            // Step 3: Find the rightmost char that is larger than chars[i]
            int j = chars.length - 1;
            while (chars[j] <= chars[i]) {
                j--;
            }

            // Step 4: Swap chars[i] and chars[j]
            swap(chars, i, j);

            // Step 5: Reverse the suffix
            reverse(chars, i + 1, chars.length - 1);

            // Print the new permutation
            System.out.println(new String(chars));
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    public static void main(String[] args) {
        String input = "ABC";
        generatePermutations(input);
    }
}

