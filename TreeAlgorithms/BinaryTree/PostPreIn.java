package TreeAlgorithms.BinaryTree;

import java.util.*;

// Node structure for the binary tree
class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize the node with a value
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

// Pair class to hold a Node and its state (1 for preorder, 2 for inorder, 3 for postorder)
class Pair<K, V> {
    K data;  // The node data
    V value; // The traversal state

    // Constructor to initialize Pair with the node and state
    Pair(K data, V value) {
        this.data = data;
        this.value = value;
    }

    // Getter for the node (data)
    public K getKey() {
        return data;
    }

    // Getter for the state (value)
    public V getValue() {
        return value;
    }

    // Setter for the state (value)
    public void setValue(V value) {
        this.value = value;
    }
}

public class PostPreIn {
    // Function to get the Preorder, Inorder, and Postorder traversal of Binary Tree in One traversal
    public static List<List<Integer>> preInPostTraversal(Node root) {
        // Lists to store traversals
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        // If the tree is empty, return empty traversals
        if (root == null) {
            return new ArrayList<>();
        }

        // Stack to maintain nodes and their traversal state
        Stack<Pair<Node, Integer>> st = new Stack<>();

        // Start with the root node and state 1 (preorder)
        st.push(new Pair<>(root, 1));

        while (!st.empty()) {
            Pair<Node, Integer> it = st.pop();

            // this is part of preorder
            if (it.getValue() == 1) {
                // Store the node's data in the preorder traversal
                pre.add(it.getKey().data);
                // Move to state 2 (inorder) for this node
                it.setValue(2);
                // Push the updated state back onto the stack
                st.push(it);

                // Push left child onto the stack for processing
                if (it.getKey().left != null) {
                    st.push(new Pair<>(it.getKey().left, 1));
                }
            }

            // this is part of inorder
            else if (it.getValue() == 2) {
                // Store the node's data in the inorder traversal
                in.add(it.getKey().data);
                // Move to state 3 (postorder) for this node
                it.setValue(3);
                // Push the updated state back onto the stack
                st.push(it);

                // Push right child onto the stack for processing
                if (it.getKey().right != null) {
                    st.push(new Pair<>(it.getKey().right, 1));
                }
            }

            // this is part of postorder
            else {
                // Store the node's data in the postorder traversal
                post.add(it.getKey().data);
            }
        }

        // Returning the traversals
        List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;
    }

    // Function to print the elements of a list
    public static void printList(List<Integer> list) {
        // Iterate through the list and print each element
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting the pre-order, in-order, and post-order traversals
        List<List<Integer>> traversals = preInPostTraversal(root);

        // Extracting the traversals from the result
        List<Integer> pre = traversals.get(0);
        List<Integer> in = traversals.get(1);
        List<Integer> post = traversals.get(2);

        // Printing the traversals
        System.out.print("Preorder traversal: ");
        printList(pre);

        System.out.print("Inorder traversal: ");
        printList(in);

        System.out.print("Postorder traversal: ");
        printList(post);
    }
}
    
                        