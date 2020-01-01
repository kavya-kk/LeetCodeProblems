package leetcode.problems.Tree;

import nodes.TreeNode;

public class LargestBSTInBT {
    public static void main(String[] str){
        TreeNode s = new TreeNode(3);
        // four is swapped with value five
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);

        // four is swapped with value five
        TreeNode two2 = new TreeNode(4);

        s.right = four;
        s.left = two;
        four.left = one;

        largestBSTSubtree(s);
    }
    public static int largestBSTSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }

        Integer[] result = helper(root);
        return result[1];
    }

    private static Integer[] helper(TreeNode root){
        if(root == null){
            //array of size 4
            // 0 -> is a valid subtree or not
            // 1 -> size of the valid subtree
            // 2 -> min value in that subtree
            // 3 -> max value in the subtree
            return new Integer[]{1,0,null, null};
        }

        Integer[] left = helper(root.left);
        Integer[] right = helper(root.right);

        // if both left and right subtrees are valid
        if(left[0] ==1 && right[0] == 1){
            //check if my value is within the range of left and right subtree's min and max respectively
            int min = left[3] == null ? Integer.MIN_VALUE : left[3];
            int max = right[2] == null ? Integer.MAX_VALUE: right[2];

            if(root.val > min && root.val < max){
                min = left[2] == null ? root.val : left[2];
                max = right[3] == null ? root.val: right[3];
                return new Integer[]{1,(left[1]+right[1]+1), min,max};
            }
        }

        return new Integer[]{0,Math.max(left[1],right[1]),root.val,root.val};
    }
}
