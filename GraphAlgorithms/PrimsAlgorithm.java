package GraphAlgorithms;

import java.util.Arrays;

public class PrimsAlgorithm {

    // Function to implement Prim's algorithm to find the Minimum Spanning Tree (MST)
    public static void primsMST(int[][] graph) {
        int V = graph.length;  // Number of vertices in the graph

        // Arrays to store the MST (Minimum Spanning Tree) edges and their weights
        int[] parent = new int[V];  // parent[i] stores the parent vertex of vertex i in MST
        int[] key = new int[V];     // key[i] stores the minimum weight edge connecting vertex i to MST
        boolean[] mstSet = new boolean[V];  // mstSet[i] is true if vertex i is included in MST

        // Initialize all keys as infinite (representing no edge), and parent and mstSet as -1 and false, respectively
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        Arrays.fill(mstSet, false);

        // Start with the first vertex (arbitrary choice)
        key[0] = 0;  // Set the key value of the first vertex to 0 to start the MST from it

        // Loop through all vertices, constructing the MST
        for (int count = 0; count < V - 1; count++) {
            // Select the vertex with the minimum key value that is not yet included in the MST
            int u = minKey(key, mstSet, V);
            
            // Include the selected vertex u in the MST
            mstSet[u] = true;

            // Update the key values and parent indices for the adjacent vertices of the selected vertex u
            for (int v = 0; v < V; v++) {
                // Only consider the vertices that are not yet in the MST and have an edge to u
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];  // Update the key value to the smaller weight
                    parent[v] = u;  // Set u as the parent of v
                }
            }
        }
        
        // Print the constructed MST
        printMST(parent, graph);
    }

    // Function to find the vertex with the minimum key value from the set of vertices
    // that are not yet included in the MST.
    public static int minKey(int[] key, boolean[] mstSet, int V) {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        // Loop through all vertices and find the vertex with the minimum key value
        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to print the MST constructed by Prim's algorithm
    public static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        // Print all the edges in the MST
        for (int i = 1; i < parent.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // Main method to test the Prim's algorithm implementation
    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix (0 indicates no edge)
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        // Call Prim's algorithm to find the MST
        primsMST(graph);
    }
}
