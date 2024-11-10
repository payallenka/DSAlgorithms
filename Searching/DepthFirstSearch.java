package Searching;

import java.util.*;

//DFS with adjacency list

public class DepthFirstSearch {

    // Method to initiate the DFS search on the graph
    public static void searchingAlgorithm(Map<Integer, List<Integer>> graph, int startNode){
        
        // Set to keep track of visited nodes, ensuring we don't visit a node multiple times
        Set<Integer> visited = new HashSet<>();
        
        // Call the recursive helper function to perform the DFS starting from the startNode
        dfsRecursive(graph, startNode, visited);
    }

    // Recursive helper method to perform DFS traversal
    private static void dfsRecursive(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited){
        
        // Mark the current node as visited and print it (or perform any other operation)
        visited.add(node);
        System.out.print(node + " ");  // Print the current node
        
        // Retrieve the list of neighbors of the current node (if any), default to an empty list if none
        List<Integer> neighbours = graph.getOrDefault(node, new ArrayList<>());

        // Iterate over all the adjacent nodes (neighbors) of the current node
        for(int neighbor : neighbours){
            // If the neighbor hasn't been visited, recursively call DFS on that neighbor
            if(!visited.contains(neighbor)){
                dfsRecursive(graph, neighbor, visited);
            }
        }
    }

    // Main method to test the DFS algorithm
    public static void main(String[] args){
        
        // Create a graph using an adjacency list representation (Map where the key is a node and value is a list of adjacent nodes)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        // Define the graph by adding edges (using lists to represent neighbors):
        // Node 1 is connected to Nodes 2 and 3
        graph.put(1, Arrays.asList(2, 3));
        
        // Node 2 is connected to Nodes 1, 4, and 5
        graph.put(2, Arrays.asList(1, 4, 5));
        
        // Node 3 is connected to Nodes 1 and 6
        graph.put(3, Arrays.asList(1, 6));
        
        // Node 4 is connected to Node 2
        graph.put(4, Arrays.asList(2));
        
        // Node 5 is connected to Node 2
        graph.put(5, Arrays.asList(2));
        
        // Node 6 is connected to Node 3
        graph.put(6, Arrays.asList(3));

        // Start DFS traversal from node 1
        System.out.println("DFS traversal starting from node 1:");
        searchingAlgorithm(graph, 1);  // Initiate DFS from node 1

        // Add a newline after the traversal
        System.out.println(" ");
    }

}
