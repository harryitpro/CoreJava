package algorithms.datasturctures.map;

/**
 * Both TreeMap and HashMap are implementations of the Map interface in Java, but they have key differences in terms of ordering, performance, and internal structure.
 * <p>
 * 1. Ordering
 * TreeMap: Maintains keys in sorted order (natural ordering or a custom comparator).
 * HashMap: Does not maintain any order; key-value pairs are stored based on hashing.
 * 2. Performance
 * TreeMap: Uses a Red-Black Tree, making operations (put, get, remove) run in O(log n) time.
 * HashMap: Uses a hash table, providing O(1) average-time complexity for operations. However, in worst-case scenarios (due to hash collisions), it can degrade to O(n).
 * 3. Null Keys and Values
 * TreeMap:
 * Does not allow null keys, but allows multiple null values.
 * Throws NullPointerException if you try to insert a null key.
 * HashMap:
 * Allows one null key and multiple null values.
 * 4. Internal Implementation
 * TreeMap: Based on a self-balancing Red-Black Tree.
 * HashMap: Uses buckets (array of linked lists or trees in case of high collisions).
 * 5. Use Cases
 * TreeMap: Used when you need sorted keys (e.g., for range-based queries, navigating keys in order).
 * HashMap: Used when you need fast lookups, without concern for key order.
 * 6. Thread-Safety
 * Neither TreeMap nor HashMap are thread-safe by default. If thread safety is needed:
 * <p>
 * Use Collections.synchronizedMap(new HashMap<>())
 * Use Collections.synchronizedSortedMap(new TreeMap<>())
 * Use ConcurrentHashMap (alternative for HashMap in multi-threaded environments)
 * Example Code
 * java
 * Copy
 * Edit
 * import java.util.*;
 * <p>
 * public class MapExample {
 * public static void main(String[] args) {
 * Map<Integer, String> hashMap = new HashMap<>();
 * hashMap.put(3, "Three");
 * hashMap.put(1, "One");
 * hashMap.put(2, "Two");
 * System.out.println("HashMap (Unordered): " + hashMap);
 * <p>
 * Map<Integer, String> treeMap = new TreeMap<>();
 * treeMap.put(3, "Three");
 * treeMap.put(1, "One");
 * treeMap.put(2, "Two");
 * System.out.println("TreeMap (Sorted): " + treeMap);
 * }
 * }
 * Output (Order May Vary for HashMap)
 * mathematica
 * Copy
 * Edit
 * HashMap (Unordered): {3=Three, 1=One, 2=Two}
 * TreeMap (Sorted): {1=One, 2=Two, 3=Three}
 * Conclusion
 * Use TreeMap when you need sorted keys.
 * Use HashMap when you need fast lookups without sorting.
 *
 */

import java.util.*;

public class MapsOverall {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Three");
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        System.out.println("HashMap (Unordered): " + hashMap);  //{1=One, 2=Two, 3=Three}


        //treeMap: red-black tree, order by key.
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        System.out.println("TreeMap (Sorted): " + treeMap); //{1=One, 2=Two, 3=Three}
    }
}

