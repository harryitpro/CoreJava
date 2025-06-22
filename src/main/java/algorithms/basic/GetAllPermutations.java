package algorithms.basic;

import java.util.*;

public class GetAllPermutations {
    public static List<String> getAllPermutations(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> list = permutation(s, "");
        return list;
    }

    private static List<String> permutation(String s, String pre) {
        if (s.length() == 1) {
            return new ArrayList<>(List.of((new StringBuilder(pre).append(s)).toString()));
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String newPre = new StringBuilder(pre).append(s.charAt(i)).toString();
            String subString = s.substring(0, i) + s.substring(i + 1, s.length());
            result.addAll(permutation(subString, newPre));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = getAllPermutations("abcd");
        System.out.println(list);
        System.out.println(list.size());
    }
}
