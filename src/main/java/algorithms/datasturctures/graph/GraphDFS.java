package algorithms.datasturctures.graph;

import java.util.*;

public class GraphDFS {
    private Map<Integer, List<Integer>> adjList;

    public GraphDFS() {
        adjList = new HashMap<>();
    }

    public void dfs(int startNode) {
        Set<Integer> visited = new HashSet<>();
        dfs(startNode, visited);
    }

    private void dfs(Integer startNode, Set<Integer> visited) {
        visited.add(startNode);
        System.out.println(startNode);
        for (Integer node : adjList.get(startNode)) {
            if (!visited.contains(node)) {
                dfs(node, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS();
        graph.adjList = Map.of(
                0, List.of(1, 2),
                1, List.of(3),
                2, List.of(),
                3, List.of()
        );
        graph.dfs(0);  // 0,1,3,2
    }
}
