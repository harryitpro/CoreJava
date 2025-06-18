package algorithms.experienced;

import java.util.*;

//dijkstra
//not study yet.
public class GraphShortestPath {
    static class Node {
        int vertex, weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(int V, int[][] graph, int src) {
        // Distance array initialized to infinity
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Priority Queue (min-heap) to store the vertices with their current shortest distance
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;
            int weightU = node.weight;

            // Process each adjacent node
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0) {  // If there is an edge from u to v
                    int newDist = weightU + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] graph = {
                {0, 10, 0, 0, 5},
                {10, 0, 1, 0, 2},
                {0, 1, 0, 4, 0},
                {0, 0, 4, 0, 3},
                {5, 2, 0, 3, 0}
        };

        int[] distances = dijkstra(V, graph, 0);
        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < V; i++) {
            System.out.println("Distance to node " + i + ": " + distances[i]);
        }
    }
}

