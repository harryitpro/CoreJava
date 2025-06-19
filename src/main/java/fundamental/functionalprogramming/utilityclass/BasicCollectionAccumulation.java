package fundamental.functionalprogramming.utilityclass;

import java.util.List;
import java.util.stream.Collectors;

public class BasicCollectionAccumulation {
    static List<String> collectToList() {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        return upperCaseNames;
    }

    public static void main(String[] args) {
        String s = "+123";
        System.out.println(Integer.parseInt(s));
    }
}
