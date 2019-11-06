package leetcode.problems;

import nodes.TreeNode;

import java.util.Stack;

public class SubTreeOrNot {
    public static void main(String[] st){
        TreeNode s = new TreeNode(14);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode six = new TreeNode(6);
        TreeNode two2 = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        s.left = four;
        s.right = two;
        four.left = six;
        four.right = two2;
        six.left = five;
        six.right = three;
        two.right = one;

        TreeNode t =two2;

        System.out.print(isSubtree(s,t));

    }

     public static boolean isSubtree(TreeNode s, TreeNode t) {
         if(s == null && t == null){
             return true;
         } else if (s!=null && t!= null) {
             Stack<TreeNode> stk = new Stack<>();
             stk.push(s);
             while (!stk.isEmpty()) {
                 TreeNode cn = stk.pop();
                 if (cn.val == t.val && areIdentical(cn, t)) {
                     return true;
                 } else {
                     if (cn.left != null) {
                         stk.push(cn.left);
                     }
                     if (cn.right != null) {
                         stk.push(cn.right);
                     }
                 }
             }
         }
        return false;
    }

    private static boolean areIdentical(TreeNode s, TreeNode t){
        if(s== null && t== null){
            return true;
        }else if ((t!=null && s!= null)&& s.val == t.val) {
            return areIdentical(s.left,t.left) && areIdentical(s.right,t.right);
        }
        return false;
    }

}
