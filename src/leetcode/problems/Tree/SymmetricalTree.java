package leetcode.problems.Tree;

import nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/symmetric-tree/
public class SymmetricalTree {
    public static void main(String[] str){

    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SymmetricTreeSolution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root,root);
    }

    public boolean helper(TreeNode n1, TreeNode n2){
        if(n1 ==null && n2 ==null){
            return true;
        }
        if(n1 == null || n2 == null){
            return false;
        }
        return n1.val == n2.val && helper(n1.left,n2.right) && helper(n1.right, n2.left);
    }

    public boolean isSymmetricIterative(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(root);

        while(!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 ==null && t2 == null){
                continue;
            }
            if(t1==null || t2==null){
                return false;
            }

            if(t1.val != t2.val){
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}