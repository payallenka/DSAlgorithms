package TreeAlgorithms.BinaryTree;

import java.util.*;


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x){
        val = x;
        left = null;
        right = null;
    }
}


public class MorrisPostorderTraversal {

    public List<Integer> getPreorder(TreeNode root){
        List<Integer> preorder = new ArrayList<>();

        TreeNode cur = root;


        while(cur != null){
            if(cur.left == null){
                preorder.add(cur.val);
                cur = cur.right;
            }
            else{
                    TreeNode prev = cur.left;

                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }else{
                    prev.right = null;
                    preorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
    
        return preorder;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        MorrisPostorderTraversal morrisPostorderTraversal = new MorrisPostorderTraversal();

        List<Integer> preorder = morrisPostorderTraversal.getPreorder(root);

        System.out.print("Binary Tree Morris Preorder Traversal ");

        for(int i = 0; i<preorder.size(); i++){
            System.out.print(preorder.get(i) + " ");
        }

        System.out.println();
    }
    
}
