package TreeAlgorithms.BinaryTree;
import java.util.*;

// Node structure for the binary tree
class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize the node with a value
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Pair<K, V> {  // Declare Pair as a generic class
    K data;  // Generic type K for the node
    V value; // Generic type V for the vertical position

    // Constructor to initialize Pair with key (node) and value (vertical position)
    public Pair(K data, V value) {
        this.data = data;
        this.value = value;
    }

    // Getter for the key (node)
    public K getKey() {
        return data;
    }

    // Getter for the value (vertical position)
    public V getValue() {
        return value;
    }
}

public class TopView {
    // Function to return the top view of the binary tree
    public List<Integer> topView(Node root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // Map to store the top view nodes based on their vertical positions
        Map<Integer, Integer> mpp = new TreeMap<>();

        // Queue for BFS traversal, each element is a pair containing node and its vertical position
        Queue<Pair<Node, Integer>> q = new LinkedList<>();

        // Push the root node with its vertical position (0) into the queue
        q.add(new Pair<>(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int line = pair.getValue();

            // If the vertical position is not already in the map, add the node's data to the map
            if (!mpp.containsKey(line)) {
                mpp.put(line, node.data);
            }

            // Process left child
            if (node.left != null) {
                q.add(new Pair<>(node.left, line - 1));
            }

            // Process right child
            if (node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        // Transfer values from the map to the result list
        for (int value : mpp.values()) {
            ans.add(value);
        }

        return ans;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        TopView solution = new TopView();

        // Get the top view traversal
        List<Integer> topView = solution.topView(root);

        // Print the result
        System.out.println("Top View Traversal: ");
        for (int node : topView) {
            System.out.print(node + " ");
        }
    }
}
