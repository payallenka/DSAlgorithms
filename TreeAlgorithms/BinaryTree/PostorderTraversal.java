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


public class PostorderTraversal {

    public static void postOrder(Node root, ArrayList<Integer> arr){

        if(root == null) return;


        postOrder(root.left, arr);
        postOrder(root.right, arr);
        arr.add(root.data);
    }

    public static ArrayList<Integer> postorder(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        postOrder(root, arr);
        return arr;
    }


    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);

        List<Integer> result = postorder(root);

        System.out.print("Post order Traversal: ");

        for(int val: result){
            System.out.print(val + " ");
        }

        System.out.println();
    }
    
}
