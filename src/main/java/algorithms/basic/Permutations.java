package algorithms.basic;

import java.util.*;

public class Permutations {
    static List<String> permutations(String s) {
        List<String> result = new ArrayList<>();
        //add root path ("") and result container as arguments
        permutations("", s, result);
        return result;
    }

    //recursive method to generate permutations for a given string.
    static void permutations(String preStr, String s, List<String> result) {
        //check complete condition
        if (s.length() == 1) {
            result.add(preStr + s);
            return;
        }
        //s.length() > 1, put each letter from s as leading
        for (int i = 0; i < s.length(); i++) {
            String newPreStr = preStr + s.charAt(i);
            String remaining = s.substring(0, i) + s.substring(i + 1, s.length());
            permutations(newPreStr, remaining, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(permutations("abc"));
    }
}
