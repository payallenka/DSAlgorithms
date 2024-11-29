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

public class LeftOrRightViewOfBinaryTree {

    public List<Integer> rightSideView(Node root){
        List<Integer> res = new ArrayList<>();
        recursionRight(root,0,res);
        return res;
    }

    public List<Integer> leftSideView(Node root){
        List<Integer> res = new ArrayList<>();
        recursionLeft(root,0,res);
        return res;
    }

    private void recursionLeft(Node root, int level, List<Integer> res){
        if(root == null){
            return;
        }

        if(res.size() == level){
            res.add(root.data);
        }

        recursionLeft(root.left, level+1, res);
        recursionLeft(root.right, level+1, res);
    }

    private void recursionRight(Node root, int level, List<Integer> res){
        if(root == null){
            return;
        }

        if(res.size() == level){
            res.add(root.data);
            recursionRight(root.right, level+1, res);
            recursionRight(root.left, level+1, res);
        }
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);

        LeftOrRightViewOfBinaryTree leftOrRightViewOfBinaryTree = new LeftOrRightViewOfBinaryTree();

        List<Integer> rightView = leftOrRightViewOfBinaryTree.rightSideView(root);

        System.out.print("Right View Traversal");

        for(int node : rightView){
            System.out.print(node + " ");
        }

        System.out.println();

        List<Integer> leftView = leftOrRightViewOfBinaryTree.leftSideView(root);

        System.out.print("Left View Traversal: ");
        for(int node : leftView){
            System.out.print(node + " ");
        }

        System.out.println();
    }
    
}
