package leetcode.problems.Tree;

import nodes.TreeNode;

public class BSTFromPreOrder {

    public static void main(String[] str){
        int[] a = {6,2,0,4,3,5,10,8,7,9,12};
        bstFromPreorder(a);
    }

    private static TreeNode bstFromPreorder(int[] a){
        TreeNode root = null;

        for (int aI:
             a ) {
            root = insert(root,aI);
        }
        return root;
    }

    private static TreeNode insert(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val > val){
            root.left = insert(root.left, val);
        }else {
            root.right = insert(root.right, val);
        }
        return root;
    }
}
