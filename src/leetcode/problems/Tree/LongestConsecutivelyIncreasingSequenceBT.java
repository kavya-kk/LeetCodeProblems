package leetcode.problems.Tree;

import nodes.TreeNode;

//https://leetcode.com/problems/binary-tree-longest-consecutive-sequence
public class LongestConsecutivelyIncreasingSequenceBT {
    public static void main(String[] str){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(5);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(5);
        TreeNode node11 = new TreeNode(6);
        TreeNode node12= new TreeNode(6);
        TreeNode node13= new TreeNode(5);
        TreeNode node14= new TreeNode(6);
        TreeNode node15= new TreeNode(7);
        TreeNode node16 = new TreeNode(6);
        TreeNode node17 = new TreeNode(8);
        TreeNode node18 = new TreeNode(7);
        TreeNode node19 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node6.left = node9;
        node6.right=node10;
        node7.right = node11;
        node8.left = node12;
        node8.right = node13;
        node9.left = node14;
        node11.left = node15;
        node13.left = node16;
        node15.left = node17;
        node16.right = node18;
        node17.right = node19;

        System.out.println(longestConsecutive(node1));
    }

    public static int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }

        return helper(root,null, 1);
    }

    private static int helper(TreeNode root, TreeNode parent, int len){
        if(root == null){
            return len;
        }

        if(parent != null && root.val == parent.val+1){
            len+=1;
        }else {
            len =1;
        }

        int leftLen = helper(root.left, root, len);
        int rightLen = helper(root.right, root,len);

        return Math.max(len,Math.max(leftLen,rightLen));

    }
}
