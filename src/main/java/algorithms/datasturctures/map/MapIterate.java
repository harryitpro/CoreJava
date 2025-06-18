package algorithms.datasturctures.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Summary: Best Method for iterating over a HashMap in multiple ways
 * Need only keys	keySet()
 * Need only values	values()
 * Need keys & values	entrySet()
 * Want simple modern syntax	forEach() (Lambda)
 * Need to remove items while iterating	Iterator: direct remove item while in iterate is not allowed
 */
public class MapIterate {
    static void iterateHashMapKey() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key);
        }
    }

    static void iterateHashMapValue() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        for (String val : map.values()) {
            System.out.println("val: " + val);
        }
    }

    static void iterateHashMapEntry() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + " " + "val: " + entry.getValue());
        }
    }

    static void iterateHashMapStream() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        map.forEach((key, val) -> System.out.println("key: " + key + " " + "val: " + val));
    }
}
