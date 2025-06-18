package algorithms.experienced;

import java.util.*;

public class StringDigitSplitter {
    private static void splitString(String s) {
        List<String> strings = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        //split string to char arrays, and split String/number respectively
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int start = index;
                // * use while loop instead of for_loop, to manually control the index in the code blocks
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    index++;
                }
                numbers.add(Integer.parseInt(s.substring(start, index)));
            }
            if (Character.isLetter(c)) {
                int start = index;
                while (index < s.length() && Character.isLetter(s.charAt(index))) {
                    index++;
                }
                strings.add(s.substring(start, index));
            }
        }
        System.out.println(strings);
        System.out.println(numbers);
    }

    public static void main(String[] args) {
        String s = "12ABC3DC";
        splitString(s);
    }
}
