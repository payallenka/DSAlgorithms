package GraphAlgorithms;

import java.util.*;

public class PrimsAlgorithm {

    // Class to represent an edge with a weight
    static class Pair {
        int node;
        int distance;
        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

    // Function to implement Prim's algorithm to find the Minimum Spanning Tree (MST)
    public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        // Priority queue to store the edges and their weights in ascending order
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] vis = new int[V];  // Array to track visited nodes
        pq.add(new Pair(0, 0));  // Start with node 0 having a weight of 0

        int sum = 0;  // To store the sum of the MST edge weights

        // Loop to process each node and construct the MST
        while (!pq.isEmpty()) {
            int wt = pq.peek().distance;  // Weight of the current edge
            int node = pq.peek().node;  // Node corresponding to the current edge
            pq.remove();  // Remove the edge from the priority queue

            // Skip if the node has already been included in the MST
            if (vis[node] == 1) continue;

            // Add the edge weight to the MST sum and mark the node as visited
            vis[node] = 1;
            sum += wt;

            // Explore the adjacent nodes and add the corresponding edges to the priority queue
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).get(1);  // Edge weight
                int adjNode = adj.get(node).get(i).get(0);  // Adjacent node

                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edW, adjNode));  // Add the adjacent node to the queue
                }
            }
        }
        return sum;  // Return the total weight of the MST
    }

    // Main method to test the Prim's algorithm implementation
    public static void main(String[] args) {
        int V = 5;  // Number of vertices in the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int[][] edges = {
            {0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}
        };

        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list with edges
        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<>();
            ArrayList<Integer> tmp2 = new ArrayList<>();

            tmp1.add(v);
            tmp1.add(w);
            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        // Call the spanningTree function to get the sum of edge weights in the MST
        int sum = spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + sum);
    }
}
