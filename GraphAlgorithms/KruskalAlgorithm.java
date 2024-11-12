package GraphAlgorithms;

import java.util.*;
import java.io.*;

// Disjoint Set (Union-Find) class to support union and find operations with path compression
class DisjointSet {

    List<Integer> rank = new ArrayList<>();  // Rank of each node
    List<Integer> parent = new ArrayList<>();  // Parent of each node
    List<Integer> size = new ArrayList<>();  // Size of each set

    // Constructor to initialize the disjoint set for 'n' nodes
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);        // Initially, rank of all nodes is 0
            parent.add(i);      // Initially, each node is its own parent
            size.add(1);        // Initially, the size of each set is 1
        }
    }

    // Find the representative (parent) of the set containing 'node' with path compression
    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;  // If node is its own parent, return it
        }
        // Path compression: recursively find the parent and update the node's parent to be the root
        int ulp = findUPar(parent.get(node)); 
        parent.set(node, ulp);  // Update the parent of 'node'
        return ulp;
    }

    // Union by Rank: Attach the smaller tree to the root of the larger tree
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;  // If already in the same set, no need to union
        
        // Union by rank: Attach the tree with lesser rank under the tree with higher rank
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);  // If both have same rank, arbitrarily make one the root
            rank.set(ulp_u, rank.get(ulp_u) + 1);  // Increment rank of the new root
        }
    }

    // Union by Size: Attach the smaller tree to the root of the larger tree
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;  // If already in the same set, no need to union

        // Union by size: Attach the smaller tree under the root of the larger tree
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));  // Update size of the new root
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));  // Update size of the new root
        }
    }
}

// Class to represent an edge with its source, destination, and weight
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    // Constructor for the edge
    Edge(int _src, int _dest, int _wt) {
        this.src = _src;
        this.dest = _dest;
        this.weight = _wt;
    }

    // Compare edges based on their weight (for sorting edges)
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class KruskalAlgorithm {

    // Function to find the sum of the weights of edges in the Minimum Spanning Tree (MST)
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge> edges = new ArrayList<Edge>();

        // Convert the adjacency list to an edge list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);  // Adjacent node
                int wt = adj.get(i).get(j).get(1);  // Weight of the edge
                int node = i;  // Current node
                Edge temp = new Edge(i, adjNode, wt);  // Create an edge object
                edges.add(temp);  // Add the edge to the list
            }
        }

        // Initialize Disjoint Set (Union-Find) to manage connected components
        DisjointSet ds = new DisjointSet(V);

        // Sort all the edges in non-decreasing order of their weights
        Collections.sort(edges);

        int mstWt = 0;  // To store the weight of the MST

        // Iterate through the sorted edges and add them to the MST if they don't form a cycle
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            // If u and v are in different sets, add the edge to the MST
            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt;  // Add the weight to the MST
                ds.unionBySize(u, v);  // Union the sets of u and v
            }
        }

        // Return the total weight of the MST
        return mstWt;
    }

    // Main function to test Kruskal's Algorithm
    public static void main(String[] args) {
        int V = 5;  // Number of vertices in the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        // List of edges represented as {u, v, weight}
        int[][] edges = {
            {0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 3}, {3, 4, 1}, {4, 2, 2}
        };

        // Initialize the adjacency list for the graph
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        // Populate the adjacency list with the edges
        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();

            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);  // Add the edge u -> v to the adjacency list
            adj.get(v).add(tmp2);  // Add the edge v -> u to the adjacency list (since it's an undirected graph)
        }

        // Create an object of KruskalAlgorithm and compute the MST weight
        KruskalAlgorithm obj = new KruskalAlgorithm();
        int mstWt = obj.spanningTree(V, adj);

        // Print the total weight of the Minimum Spanning Tree
        System.out.println("The sum of all the edge weights: " + mstWt);
    }
}
