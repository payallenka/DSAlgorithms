package GraphAlgorithms;

//distance between every pair of vertices

public class FloydWarshall {

    // This function implements the Floyd-Warshall algorithm to find the shortest paths between all pairs of vertices
    public static void floydWarshall(int[][] graph) {
        int V = graph.length; // Get the number of vertices in the graph

        // Initialize the distance matrix, dist, which will store the shortest distances
        int[][] dist = new int[V][V];

        // Step 1: Initialize the distance matrix with the graph's edge weights
        // dist[i][j] will be initialized to:
        // - 0 if i == j (distance to itself is 0)
        // - graph[i][j] if there's a direct edge between i and j (non-zero value in the graph)
        // - Integer.MAX_VALUE if there's no direct edge between i and j (i.e., graph[i][j] == 0)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    dist[i][j] = 0; // Distance to itself is always 0
                } else if (graph[i][j] != 0) {
                    dist[i][j] = graph[i][j]; // If there's a direct edge, use the weight of the edge
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // No direct edge between i and j
                }
            }
        }

        // Step 2: Implement the Floyd-Warshall algorithm
        // The algorithm iterates through all possible intermediate vertices (k),
        // and for each pair of vertices (i, j), it checks if the path through the intermediate vertex (k)
        // offers a shorter path than the current known path.
        for (int k = 0; k < V; k++) { // Loop through all vertices as the intermediate vertex k
            for (int i = 0; i < V; i++) { // Loop through each vertex i
                for (int j = 0; j < V; j++) { // Loop through each vertex j
                    // If there is a valid path from i to k and k to j, check if it improves the current distance
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        // Update dist[i][j] if a shorter path via k is found
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Step 3: Print the final distance matrix, which contains the shortest paths
        printSolution(dist);
    }

    // This function prints the distance matrix
    // The matrix shows the shortest distance between every pair of vertices
    public static void printSolution(int[][] dist) {
        int V = dist.length; // Get the number of vertices
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");

        // Loop through each pair of vertices and print the shortest distance between them
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // If the distance is infinity, print "INF" to indicate no path exists
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " "); // Print the shortest distance
                }
            }
            System.out.println(); // Print a new line after each row of the matrix
        }
    }

    // Main function to test the Floyd-Warshall algorithm
    public static void main(String[] args) {
        // Define the graph as an adjacency matrix
        // A value of 0 means no direct edge, and a non-zero value represents the edge weight between vertices
        int[][] graph = {
            {0, 5, 2, 0},  // Edges from vertex 0 to 1 (weight 5), 0 to 2 (weight 2)
            {4, 0, 3, 0},  // Edges from vertex 1 to 0 (weight 4), 1 to 2 (weight 3)
            {0, 0, 0, 7},  // Edge from vertex 2 to 3 (weight 7)
            {0, 0, 0, 0}   // No edges from vertex 3
        };

        // Call the Floyd-Warshall function to calculate the shortest paths
        floydWarshall(graph);
    }
}
