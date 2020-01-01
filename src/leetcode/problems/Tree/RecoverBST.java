package leetcode.problems.Tree;

import nodes.TreeNode;

//https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBST {

    public static void main(String[] str){
        TreeNode s = new TreeNode(7);
        // four is swapped with value five
        TreeNode four = new TreeNode(5);
        TreeNode two = new TreeNode(11);
        TreeNode six = new TreeNode(1);

        // four is swapped with value five
        TreeNode two2 = new TreeNode(4);

        s.left = four;
        s.right = two;
        four.left = six;
        four.right = two2;

        recoverTree(s);
    }

    static TreeNode prevNode = null;
    static TreeNode xNode = null;
    static TreeNode yNode = null;

    public static void recoverTree(TreeNode root) {
        inorderHelper(root);

        int temp = xNode.val;
        xNode.val = yNode.val;
        yNode.val = temp;

        return;
    }

    public static void inorderHelper(TreeNode root){
        if(root == null){
            return;
        }

        inorderHelper(root.left);

        if(prevNode == null || prevNode.val < root.val){
            prevNode = root;
        }else {
            yNode = root;
            if(xNode ==null){
                xNode = prevNode;
            }
        }

        inorderHelper(root.right);

    }
}
