package GraphAlgorithms;

import java.util.*;

// Pair class: Represents a pair of vertex and its associated distance (vertex, distance)
class Pair {
    int first, second;
    
    // Constructor to initialize the pair
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Dijikstra {
    
    // Static method to find the shortest distance from the source vertex to all other vertices
    public static ArrayList<Integer> dijikstra(ArrayList<ArrayList<Pair>> adj, int src) {

        // Number of vertices in the graph
        int V = adj.size();

        // ArrayList to store the shortest distance of each vertex from the source
        ArrayList<Integer> dist = new ArrayList<>();

        // Initialize all distances as infinity (Integer.MAX_VALUE) except the source vertex
        for (int i = 0; i < V; i++) {
            dist.add(Integer.MAX_VALUE);  // Initially, set all distances to infinity
        }

        // Set the distance of the source vertex to 0 (since it's the starting point)
        dist.set(src, 0);

        // Priority queue to store pairs of (vertex, distance), ordered by distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);

        // Add the source vertex to the priority queue with distance 0
        pq.add(new Pair(src, 0));

        // Main loop: Process each vertex in the priority queue
        while (!pq.isEmpty()) {
            // Extract the vertex with the smallest distance from the priority queue
            Pair node = pq.poll();
            int u = node.first;  // 'u' is the current vertex

            // Now, for the current vertex 'u', we check all its neighbors
            for (Pair it : adj.get(u)) {
                // 'it.first' is the neighbor vertex 'v', 'it.second' is the edge weight
                int v = it.first;      // Neighbor vertex
                int weight = it.second; // Weight of the edge between 'u' and 'v'

                // Relaxation step: Check if the known distance to 'v' can be improved by going through 'u'
                if (dist.get(v) > dist.get(u) + weight) {
                    // If a shorter distance to 'v' is found, update the distance and add 'v' to the queue
                    dist.set(v, dist.get(u) + weight);  // Update distance to 'v'
                    pq.add(new Pair(v, dist.get(v)));  // Add the updated vertex 'v' to the priority queue
                }
            }
        }

        // After processing all vertices, return the array containing the shortest distances
        return dist;
    }

    // Main method to run and test the Dijkstra algorithm
    public static void main(String[] args) {
        // Create a graph with 5 vertices (0 to 4)
        int V = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // Initialize the adjacency list for each vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph: (u, v, weight)
        adj.get(0).add(new Pair(1, 10));  // Vertex 0 is connected to 1 with weight 10
        adj.get(0).add(new Pair(4, 5));   // Vertex 0 is connected to 4 with weight 5
        adj.get(1).add(new Pair(2, 1));   // Vertex 1 is connected to 2 with weight 1
        adj.get(1).add(new Pair(4, 2));   // Vertex 1 is connected to 4 with weight 2
        adj.get(2).add(new Pair(3, 4));   // Vertex 2 is connected to 3 with weight 4
        adj.get(3).add(new Pair(0, 7));   // Vertex 3 is connected to 0 with weight 7
        adj.get(4).add(new Pair(2, 9));   // Vertex 4 is connected to 2 with weight 9

        // Source vertex is 0
        int src = 0;

        // Call the dijikstra function to calculate shortest paths from the source vertex
        ArrayList<Integer> distances = dijikstra(adj, src);  

        // Print the shortest distances from the source (vertex 0)
        System.out.println("Shortest distances from vertex " + src + ":");
        for (int i = 0; i < distances.size(); i++) {
            System.out.println("Distance to vertex " + i + ": " + distances.get(i));
        }
    }
}
