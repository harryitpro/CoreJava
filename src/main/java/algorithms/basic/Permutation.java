package algorithms.basic;

import java.util.*;

public class Permutation {
    static List<String> permutation(String s) {
        List<String> result = new ArrayList<>();
        String root = "";
        permutation(root, s, result);
        return result;
    }

    //One Node processing.
    //Recursive method, or BackTracking essentially is a tree build and tree processing
    static void permutation(String pathString, String s, List<String> result) {
        if (s.isEmpty()) {
            result.add(pathString);
            return; // return to parent node
        }
        //otherwise processing current node:
        for (int i = 0; i < s.length(); i++) {
            String newPath = pathString + s.charAt(i);
            String remaining = s.substring(0, i) + s.substring(i + 1, s.length()); //lower the scope of question
            permutation(newPath, remaining, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(permutation("abcd"));
    }
}
