package Searching;

import java.util.*;

public class BreadthFirstSearch {
    
    // BFS algorithm to perform breadth-first search on a graph represented by an adjacency list
    public static void searchingAlgorithm(Map<Integer, List<Integer>> graph, int startNode){
        // Set to keep track of visited nodes, to avoid processing the same node multiple times
        Set<Integer> visited = new HashSet<>();
        // Queue to manage the nodes for BFS traversal (FIFO order)
        Queue<Integer> queue = new LinkedList<>();

        // Mark the starting node as visited and add it to the queue
        visited.add(startNode);
        queue.add(startNode);

        // Continue processing the queue until it's empty
        while(!queue.isEmpty()){
            // Dequeue the front node from the queue for processing
            int currentNode = queue.poll();
            
            // Print the current node (node number starts from 0, so we add 1 to make it human-friendly)
            System.out.print((currentNode + 1) + " ");  // Printing nodes with 1-based index

            // Get all neighbors (adjacent nodes) of the current node
            List<Integer> neighbours = graph.getOrDefault(currentNode, new ArrayList<>());
            
            // Explore each neighbor of the current node
            for(int neighbor : neighbours){
                // If the neighbor has not been visited, mark it visited and add it to the queue
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);  // Mark the neighbor as visited
                    queue.add(neighbor);    // Enqueue the neighbor for future processing
                }
            }
        }
    }

    public static void main(String[] args){

        // Create a graph using an adjacency list representation
        // Map where the key is a node and the value is a list of adjacent nodes
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        // Define the edges in the graph (undirected graph)
        graph.put(0, Arrays.asList(1, 2)); // Node 1 is connected to Nodes 2 and 3
        graph.put(1, Arrays.asList(0, 3, 4)); // Node 2 is connected to Nodes 1, 4, and 5
        graph.put(2, Arrays.asList(0)); // Node 3 is connected to Node 1
        graph.put(3, Arrays.asList(1)); // Node 4 is connected to Node 2
        graph.put(4, Arrays.asList(1)); // Node 5 is connected to Node 2

        // Print the BFS traversal starting from node 1 (index 0 in the adjacency list)
        System.out.println("BFS traversal starting from node 1: ");
        searchingAlgorithm(graph, 0);  // Start BFS from node 1 (index 0)

        System.out.println();  // Print a newline after the BFS traversal
    }
}
