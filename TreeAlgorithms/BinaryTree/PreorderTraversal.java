package TreeAlgorithms.BinaryTree;

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    Node(int val){
        data = val;
        left = null;
        right = null;
    }
}

public class PreorderTraversal {
    

    public static void PreOrder(Node root, List<Integer> arr){
        if(root == null){
            return;
        }


        arr.add(root.data);
        PreOrder(root.left, arr);
        PreOrder(root.right, arr);

    }


    public static List<Integer> preorderTraversal(Node root){
        List<Integer> arr = new ArrayList<>();


        PreOrder(root,arr);

        return arr;
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);

        List<Integer> result = preorderTraversal(root);

        System.out.print("Preorder Traversal: ");

        for(int val: result){
            System.out.print(val + " ");
        }

        System.out.println();
    }
}
