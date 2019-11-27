package leetcode.problems.Tree;

import nodes.TreeNode;

public class LeastCommonAncestorBST {
    public static void main(String[] ts){
        TreeNode s = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        s.left = two;
        s.right = eight;
        two.left = zero;
        two.right = four;
        four.left = three;
        four.right = five;
        eight.left = seven;
        eight.right= nine;
        System.out.println(lowestCommonAncestor(s, s, eight).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val || (root.val>p.val && root.val<q.val) || (root.val<p.val && root.val>q.val)){
            return root;
        } else if (root.val < p.val && root.val <q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else if (root.val >p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        return root;
    }
}
