package leetcode.problems.Tree;

import nodes.TreeNode;
//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class BTMaxSumPath {
    static int globalMax =Integer.MIN_VALUE;

    public static void main(String[] str){
        TreeNode root = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        //s.left = two;
        root.right = eight;
        two.left = zero;
        two.right = four;
        four.left = three;
        four.right = five;
        eight.left = seven;
        eight.right= nine;
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        helper(root);
        return globalMax;
    }

    public static int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftMax = Math.max(0,helper(root.left));
        int rightMax = Math.max(0,helper(root.right));

        int posNewMax = leftMax+rightMax+root.val;
        globalMax = Math.max(globalMax,posNewMax);

        return root.val+Math.max(leftMax,rightMax);
    }
}
