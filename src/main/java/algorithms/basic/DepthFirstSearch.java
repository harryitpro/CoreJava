package algorithms.basic;

import java.util.*;

public class DepthFirstSearch {
    static List<Integer> depthFirstSearch(Map<Integer, List<Integer>> graph) {
        //go through each Integer using DFS algorithm
        Set<Integer> visited = new LinkedHashSet<>();  //keep the order of node traversing
        //Graph could be disconnected, get the starting points if not specified
        for (Integer key : graph.keySet()) {
            if (!visited.contains(key)) {
                depthFirstSearch(graph, key, visited);
            }
        }
        return new ArrayList<>(visited);
    }

    static void depthFirstSearch(Map<Integer, List<Integer>> graph, Integer key, Set<Integer> visited) {
        visited.add(key);  //also the consumption of the key
        List<Integer> adjs = graph.get(key);  //there maybe null value for the given key.
        if (adjs != null) {  //
            for (Integer adj : adjs) {
                if (!visited.contains(adj)) {
                    depthFirstSearch(graph, adj, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, List.of(1, 2));
        graph.put(1, List.of(3,4));
        graph.put(2, List.of(5,6));
        graph.put(3, List.of(7));
        graph.put(4, List.of(7));
        graph.put(5, List.of(8));
        graph.put(6, List.of(8));
        graph.put(9, Collections.emptyList());
        List<Integer> list = depthFirstSearch(graph);
        System.out.println(list); //[0, 1, 3, 7, 4, 2, 5, 8, 6, 9]
    }
}
