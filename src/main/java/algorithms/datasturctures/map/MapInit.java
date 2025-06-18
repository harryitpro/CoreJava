package algorithms.datasturctures.map;

import java.util.HashMap;
import java.util.Map;

/**
 * There are multiple ways to initialize a Map in Java, depending on the use case. Here are some common methods:
 * Method	Mutable?	Java Version	Best Use Case
 * put()	✅ Yes	Any	General use
 * Double Brace	✅ Yes	Any	Avoid due to memory issues
 * new HashMap<>(Map.of())	✅ Yes	Java 9+	Mutable map with initialization

 * Map.of()	❌ No	Java 9+	Small, fixed-size maps
 * Map.ofEntries()	❌ No	Java 9+	Large, fixed-size maps
 * Stream API	❌ No	Java 8+	Functional programming
 */
public class MapInit {

    //Mutable init a map
    static void put() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);
        System.out.println(map); // Output: {Apple=10, Banana=20, Orange=30}
    }

    //Immutable,
    //Factory method,
    //entry pair literal
    static void OfStaticMethod() {
        Map<String, Integer> map = Map.of(
                "Apple", 10,
                "Banana", 20,
                "Orange", 30
        );
        System.out.println(map); // Output: {Apple=10, Banana=20, Orange=30}
    }

    static void ofEntriesStaticMethod() {
        Map<String, Integer> map = Map.ofEntries(
                Map.entry("Apple", 10),
                Map.entry("Banana", 20),
                Map.entry("Cherry", 30)
        );
        System.out.println(map); // Output: {Apple=10, Banana=20, Orange=30}
    }
}
