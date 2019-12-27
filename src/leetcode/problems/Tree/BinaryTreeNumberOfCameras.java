package leetcode.problems.Tree;

import nodes.TreeNode;

public class BinaryTreeNumberOfCameras {

    public static void main(String[] str){
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
        System.out.println(minCameraCover(s));
    }

    public static int noOfCameras =0;
    public static int minCameraCover(TreeNode root) {
        return (dfs(root)<1 ? 1:0) + noOfCameras ;
    }

    public static int dfs(TreeNode root) {
        if(root == null){
            // denotes there are no cameras to be placed
            return 2;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        // if either of the children do not have cameras place a camera here.
        if(left ==0 || right ==0){
            noOfCameras++;
            // since a camera is placed here return that information to the parent.
            return 1;
        }
        // if either of the children has a camera on it, I dont need to have a camera so return 2 denoting that there is no camera on me.
        // if none of the children has a camera then return 0;
        //          denoting there are no children, since on line 42 we have already checked for child presence and no cameras.
        return (left ==1 || right ==1)? 2:0;
    }
}
