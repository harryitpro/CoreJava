package algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendationSolution {
    //represent a transaction using a List<String>: the product name list within the order.
    //for all transactions, List<List<String>>;

    public static Map<String, Integer> fillItemFreq(List<List<String>> trans, String keyItem) {
        return trans.stream() // Stream<List<String>>
                //                .flatMap(List::stream) // Flatten to Stream<String>
                .flatMap(strList -> strList.stream())
                .filter(item -> !item.equals(keyItem)) // Filter out the keyItem
                .collect(Collectors.toMap(
                        item -> item,             // Key Mapper: the item itself
                        item -> 1,                // Value Mapper: start count at 1 for each item
                        Integer::sum              // Merge Function: how to combine counts for duplicate keys
                ));
    }

    public static List<String> recommend(String item, int limit, List<List<String>> transactions) {
        List<String> recommended = new ArrayList<>();
        //build an itemFreq data structure to hold co-purchased items and their count

        //pick the first "limit" items as recommendations.
        Map<String, Integer> itemFreq = fillItemFreq(transactions, item);
        int min = Math.min(limit, itemFreq.size());
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(itemFreq.entrySet());
        recommended = entries.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(min)
                .map(e -> e.getKey())
                .collect(Collectors.toUnmodifiableList());
        return recommended;
    }
}