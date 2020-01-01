package leetcode.problems.Tree;

import nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return inOrder(root, new ArrayList<>());
    }

    private boolean inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return true;
        }
        if(!inOrder(root.left, list)){
            return false;
        }

        if(!list.isEmpty() && list.get(list.size()-1) >= root.val){
            return false;
        }else {
            list.add(root.val);
        }

        if(!inOrder(root.right, list)){
            return false;
        }

        return true;
    }
}
