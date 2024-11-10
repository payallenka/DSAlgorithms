package GraphAlgorithms;

import java.util.*;

public class BellmanFord {

    // Static inner class to represent an edge
    static class Edge {
        int u, v, weight;
        
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    // Bellman-Ford algorithm implementation
    public static void bellmanFord(List<Edge> edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges V-1 times == i.e., checking if that part can be shortened
        for (int i = 1; i < V; i++) {
            for (Edge edge : edges) {
                int u = edge.u;
                int v = edge.v;
                int weight = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Negative cycle check
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int weight = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Print distances
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + " is unreachable from source.");
            } else {
                System.out.println("Distance to vertex " + i + ": " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));
        
        // Run Bellman-Ford from vertex 0
        bellmanFord(edges, 5, 0);
    }
}
