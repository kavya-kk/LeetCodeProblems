package leetcode.problems.Tree;

import nodes.TreeNode;

//https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii
public class LongestConsecutiveSequenceBTII {

    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }

        int[] result = helper(root);

        return maxLen;
    }

    public int[] helper(TreeNode root){
        if(root == null){
            // 0->increasingSeqLen, 1->decreasingSeqLen;
            return new int[]{0,0};
        }


        int[] result = new int[]{1,1};
        int leftRel = 0 , rightRel = 0 ;

        if(root.left == null && root.right==null){
            result[0]=result[1]=1;
        }

        if(root.left != null){
            int[] left = helper(root.left);
            leftRel = root.val - root.left.val;
            if(leftRel == -1){
                //increasing seq
                result[0] = left[0]+1;
            }else if (leftRel == 1){
                //decreasing seq
                result[1] = left[1]+1;
            }
        }

        if(root.right !=null){
            int[] right = helper(root.right);
            rightRel = root.val - root.right.val;
            if(rightRel == -1){
                //increasing seq
                result[0] = Math.max(result[0],right[0]+1);
            }else if (rightRel == 1){
                //decreasing seq
                result[1] = Math.max(result[1],right[1]+1);
            }
        }

        maxLen = Math.max(maxLen, result[0]+result[1]-1);
        return result;
    }
}
