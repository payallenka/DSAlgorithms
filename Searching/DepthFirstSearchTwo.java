package Searching;

public class DepthFirstSearchTwo {

    // Method to initiate the DFS search on the graph represented by an adjacency matrix
    public static void searchingAlgorithm(int[][] matrix, int startNode){
        
        // Create a boolean array to keep track of visited nodes (initialized to false)
        boolean[] visited = new boolean[matrix.length];

        // Call the recursive DFS helper method starting from the given node
        dfsRecursive(matrix, startNode, visited);
    }

    // Recursive helper method to perform DFS traversal
    public static void dfsRecursive(int[][] matrix, int node, boolean[] visited){
        
        // Mark the current node as visited
        visited[node] = true;

        // Print the current node 
        System.out.print((node) + " ");  // Print the current node (for user-friendly output)

        // Explore all neighbors of the current node by checking the adjacency matrix
        for(int i = 0; i < matrix.length; i++){
            // Check if there is an edge between the current node and node `i`
            // matrix[node][i] == 1 means there is an edge between node and i
            if(matrix[node][i] == 1 && !visited[i]){
                // If the neighbor node `i` has not been visited, recursively call DFS on it
                dfsRecursive(matrix, i, visited);
            }
        }
    }

    // Main method to test the DFS algorithm
    public static void main(String[] args){

        // Adjacency matrix representing the graph
        int[][] matrix = {
            {0, 1, 1, 0, 0, 0}, // Node 1 is connected to Node 2 and Node 3
            {1, 0, 0, 1, 1, 0}, // Node 2 is connected to Node 1, Node 4, and Node 5
            {0, 1, 0, 0, 0, 0}, // Node 3 is connected to Node 2
            {0, 1, 0, 0, 0, 0}, // Node 4 is connected to Node 2
            {0, 0, 1, 0, 0, 0}  // Node 5 is connected to Node 3
        };

        // Print message indicating the start of DFS traversal
        System.out.println("DFS traversal starting from node 1: ");
        
        // Call the searchingAlgorithm method to initiate DFS starting from node 1 (index 0)
        searchingAlgorithm(matrix, 0); // 0 is the index for node 1 in the matrix

        // Add a new line after the traversal output
        System.out.println();
    }
}
