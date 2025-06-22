package algorithms.basic;

import java.util.*;

public class GraphBFS {
    static List<Integer> bfs(Map<Integer, List<Integer>> graph) {
        if ((graph == null) || graph.isEmpty())
            return Collections.emptyList();

        Set<Integer> visited = new LinkedHashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (Integer start : graph.keySet()) {
            if (!visited.contains(start)) {
                queue.add(start);
                while (!queue.isEmpty()) {
                    Integer key = queue.poll();
                    if (!visited.contains(key)) {
                        visited.add(key);
                        List<Integer> adjs = graph.get(key);
                        if (adjs != null) {
                            for (Integer adj : adjs) {
                                if (!visited.contains(adj))
                                    queue.addAll(graph.get(key));
                            }
                        }
                    }
                }
            }
        }

        return new ArrayList<>(visited);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, List.of(1, 2));
        graph.put(1, List.of(3, 4));
        graph.put(2, List.of(5, 6));
        graph.put(3, List.of(7));
        graph.put(4, List.of(7));
        graph.put(5, List.of(8));
        graph.put(6, List.of(8));
        graph.put(9, Collections.emptyList());
        List<Integer> list = bfs(graph);
        System.out.println(list); //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
