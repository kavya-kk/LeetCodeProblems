package leetcode.problems.Tree;

import nodes.TreeNode;

public class MorrisInorderTraversal {

    public static void main(String[] ts){
        TreeNode s = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode zero = new TreeNode(1);
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
        System.out.println(inorderTraversal(s));
    }

    private static String inorderTraversal(TreeNode root){
        String result = "";
        if(root == null){
            return result;
        }
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                result += cur.val+",";
                cur =cur.right;
            }else {
                TreeNode predecessor = findPredecessor(cur);
                if(predecessor.right == null){
                    predecessor.right = cur;
                    cur = cur.left;
                }else {
                    predecessor.right = null;
                    result += cur.val+",";
                    cur = cur.right;
                }
            }
            System.out.println(result);
        }
        return result;
    }

    private static TreeNode findPredecessor(TreeNode root){
        // predecessor is the rightmost node on the left subtree.
        TreeNode predecessor = root.left;
        while(predecessor.right!=root && predecessor.right!=null){
            predecessor = predecessor.right;
        }
        System.out.println("test");
        return predecessor;
    }
}
