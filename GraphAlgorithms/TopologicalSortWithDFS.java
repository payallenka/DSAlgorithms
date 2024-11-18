package GraphAlgorithms;

import java.util.*;
import java.io.*;

public class TopologicalSortWithDFS {
    
    // Function to check if the graph has a cycle and perform topological sorting
    public static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj){
        
        // Array to store topological sort result
        int topo[] = new int[N];
        
        // Array to store the indegree of each node
        int indegree[] = new int[N];

        // Calculate the indegree for each node (number of incoming edges)
        for(int i = 0; i < N; i++){
            for(Integer it : adj.get(i)){
                indegree[it]++;  // Increment indegree for each neighboring node
            }
        }

        // Queue to perform BFS
        Queue<Integer> q = new LinkedList<>();
        
        // Add all nodes with zero indegree (no incoming edges) to the queue
        for(int i = 0; i < N; i++){
            if(indegree[i] == 0) q.add(i);
        }

        // Initialize variables
        int cnt = 0;  // To count the number of nodes processed
        int ind = 0;  // To track the index in the topological order
        
        // Perform BFS to generate topological order
        while(!q.isEmpty()){
            Integer node = q.poll();
            topo[ind++] = node;  // Add node to topological order
            cnt++;  // Increment the processed nodes count

            // Reduce indegree for all neighbors of the current node
            for(Integer it : adj.get(node)){
                indegree[it]--;  // Decrement indegree as the edge is removed
                if(indegree[it] == 0){  // If indegree becomes zero, add to queue
                    q.add(it);
                }
            }
        }

        // Output the topological sort result
        for(int i = 0; i < topo.length; i++){
            System.out.print(topo[i] + " ");
        }
        System.out.println();  // Print a newline after the result

        // If the number of processed nodes is less than N, the graph has a cycle
        if(cnt == N) return false;  // No cycle, valid topological sort
        return true;  // Cycle exists
    }

    public static void main(String args[]){
        
        // Create adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize the adjacency list with empty lists for each node
        for(int i = 0; i < 6; i++){
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph (directed edges)
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(3).add(1);
        adj.get(2).add(3);

        // Call the isCyclic function and check for a cycle in the graph
        boolean result = isCyclic(6, adj);
        
        // Print the result
        if (result) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle and the topological sort is possible.");
        }
    }
}
