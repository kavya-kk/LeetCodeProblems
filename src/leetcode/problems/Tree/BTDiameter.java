package leetcode.problems.Tree;

import nodes.TreeNode;
//https://leetcode.com/problems/diameter-of-binary-tree/
public class BTDiameter {
   static int diameter = 0;

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
        System.out.println(diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    public static int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftMax  = helper(root.left);
        int rightMax = helper(root.right);

        int newDia = leftMax+rightMax;

        diameter =Math.max(newDia,diameter);

        return Math.max(leftMax,rightMax)+1;
    }
}
