package Searching;

import java.util.*;

public class BreadthFirstSearchTwo {

    // This method performs the Breadth-First Search (BFS) on a graph represented by an adjacency matrix.
    public static void searchingAlgorithm(int[][] matrix, int startNode){

        // Array to keep track of visited nodes, to prevent revisiting the same node
        boolean[] visited = new boolean[matrix.length];
        // Queue to manage the BFS traversal (FIFO order)
        Queue<Integer> queue = new LinkedList<>();

        // Mark the start node as visited and add it to the queue
        visited[startNode] = true;
        queue.add(startNode);

        // Process the queue until it is empty
        while(!queue.isEmpty()){
            // Dequeue the front node from the queue
            int currentNode = queue.poll();
            
            // Print the current node. The node is 0-based, so it represents the node by index.
            System.out.print(currentNode + " ");  // Print nodes starting from 0, which is the typical index

            // Iterate through all the nodes to find neighbors of the current node
            for(int i = 0; i < matrix.length; i++){
                // Check if there is an edge between currentNode and node i (i.e., matrix[currentNode][i] == 1)
                // Also, make sure the neighbor has not been visited yet
                if(matrix[currentNode][i] == 1 && !visited[i]){
                    // Mark the neighbor as visited and enqueue it for future processing
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args){

        // Adjacency matrix representation of a graph
        // Here, 0 means no edge between nodes and 1 means there is an edge
        int[][] matrix = {
            {0, 1, 1, 0, 0}, // Node 1 is connected to Node 2 and Node 3
            {1, 0, 0, 1, 1}, // Node 2 is connected to Node 1, Node 4, and Node 5
            {1, 0, 0, 0, 0}, // Node 3 is connected to Node 1
            {0, 1, 0, 0, 0}, // Node 4 is connected to Node 2
            {0, 1, 0, 0, 0}, // Node 5 is connected to Node 2
        };

        // Print the BFS traversal starting from node 1 (index 0)
        System.out.println("BFS traversal starting from node 1: ");
        searchingAlgorithm(matrix, 0);  // Start BFS from node 1 (index 0)

        // Print a newline after BFS traversal is complete
        System.out.println();
    }
}
