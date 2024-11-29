package TreeAlgorithms.BinaryTree;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Pair {
    Node data;
    Integer value;

    public Pair(Node node, Integer value) {
        this.data = node;
        this.value = value;
    }
}

public class TopOrBottomView {

    public List<Integer> bottomView(Node root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // Map to store the horizontal distance and the corresponding node value
        Map<Integer, Integer> mpp = new TreeMap<>();

        // Queue for level order traversal
        Queue<Pair> q = new LinkedList<>();
        
        // Start with the root node at horizontal distance 0
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            // Get the front element from the queue
            Pair temp = q.poll();
            Node currNode = temp.data;
            int hd = temp.value;

            // Update the map with the current node
            mpp.put(hd, currNode.data);

            // Add left child with horizontal distance - 1
            if (currNode.left != null) {
                q.add(new Pair(currNode.left, hd - 1));
            }

            // Add right child with horizontal distance + 1
            if (currNode.right != null) {
                q.add(new Pair(currNode.right, hd + 1));
            }
        }

        // Add the values from the map to the result list
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        BottomView bottomViewObj = new BottomView();

        List<Integer> bottomView = bottomViewObj.bottomView(root);
        System.out.println("Bottom View Traversal: ");

        for (int node : bottomView) {
            System.out.print(node + " ");
        }
    }
}
