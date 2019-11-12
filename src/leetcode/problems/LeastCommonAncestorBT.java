package leetcode.problems;

import nodes.TreeNode;

public class LeastCommonAncestorBT {
    public static void main(String[] str){
        TreeNode six = new TreeNode(6);
        TreeNode  two= new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);

        three.right=one;
        three.left =five;

        five.left = six;
        five.right= two;

        one.left = zero;
        one.right=eight;

        two.left=seven;
        two.right= four;

        System.out.println(lowestCommonAncestor(three,seven,three).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || p== root|| q == root){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }

        return left==null?right:left;
    }
}
