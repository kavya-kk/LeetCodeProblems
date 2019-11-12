package leetcode.problems;

import nodes.TreeNode;

public class MinDepthOfBinaryTree {
    public static void main(String[] str){
        TreeNode s = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        //s.left = two;
        s.right = eight;
        two.left = zero;
        two.right = four;
        four.left = three;
        four.right = five;
        eight.left = seven;
        eight.right= nine;
        System.out.println(minDepth(s));
    }

    private static int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = root.left == null? Integer.MAX_VALUE: (minDepth(root.left)+1);
        int right = root.right == null? Integer.MAX_VALUE:(minDepth(root.right)+1);

        return Math.min(left,right);
    }
}
