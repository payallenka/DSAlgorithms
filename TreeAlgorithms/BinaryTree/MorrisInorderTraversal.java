package TreeAlgorithms.BinaryTree;

import java.util.ArrayList;
import java.util.List;


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
public class MorrisInorderTraversal {

    public List<Integer> getInorder(TreeNode root){
        List<Integer> inorder = new ArrayList<>();
        TreeNode cur = root;

        while(cur!=null){
            if(cur.left == null){
                inorder.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }else{
                    prev.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        MorrisInorderTraversal morrisInorderTraversal = new MorrisInorderTraversal();

        List<Integer> inorder = morrisInorderTraversal.getInorder(root);

        System.out.print("Binary Tree Morris Inorder Traversal: ");

        for(int i = 0; i<inorder.size(); i++){
            System.out.print(inorder.get(i) + " ");
        }
        System.out.println();
    }
    
}
