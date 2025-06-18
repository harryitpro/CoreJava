package algorithms.datasturctures.graph;

import java.util.*;

public class GraphBFS {
    private Map<Integer, List<Integer>> adjList;

    public GraphBFS() {
        adjList = new HashMap<>();
    }

    //iterate
    //    Time Complexity	O(V + E) (Vertices + Edges)
    //    Space Complexity	O(V) (For queue & visited set)

    /**
     * How BFS Works
     * Start at the source node: Pick a node to begin (e.g., node A).
     * Enqueue and mark: Add the source to a queue and mark it as visited.
     * Process the queue: While the queue isn’t empty:
     * Dequeue a node (take the front one).
     * Visit/process it (e.g., print it).
     * Enqueue all its unvisited neighbors.
     * Repeat: Continue until the queue is empty.
     */
    public void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " "); // Process node

            for (int neighbor : adjList.get(node)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }


    /**
     * 0 ->{1,2}
     * 1 -> {2,3}
     */
    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS();
        graph.adjList = Map.of(
                0, List.of(1, 2),
                1, List.of(2,3),
                2, List.of(),
                3, List.of()
        );
        graph.bfs(0);
    }
}
