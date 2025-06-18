package basic.recursiveprogramming;

/**
 * reverse a given using recursive programming
 * recursive:
 * a method call chain with smaller scope of input
 * unwind till the certain returning condition is met
 */
public class ReverseString {
    /**
     * a recursive method call chain. each call will lower the input scope by a substring of current string
     * return condition: string only contains 1 character.
     */
    static String reverse(String s) {
        if (s.length() == 1) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        String reversed = reverse("abcde");
        System.out.println(reversed); //expected edcba
        /**
         * output: edcba
         */
    }
}

