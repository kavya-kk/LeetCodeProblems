package leetcode.problems.Tree;

import nodes.TreeNode;

public class BinarySearchTreeInsertion {
    public static void main(String[] st){
        TreeNode s = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(11);
        TreeNode six = new TreeNode(1);
        TreeNode two2 = new TreeNode(5);

        s.left = four;
        s.right = two;
        four.left = six;
        four.right = two2;

        insert(s,0);

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
