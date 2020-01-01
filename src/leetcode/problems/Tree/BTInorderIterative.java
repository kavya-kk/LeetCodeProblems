package leetcode.problems.Tree;

import nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BTInorderIterative {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder  = new ArrayList<>();
        if(root == null){
            return inOrder;
        }
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while(!stk.isEmpty() || cur!=null){
            while(cur!=null){
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            inOrder.add(cur.val);
            cur = cur.right;
        }
        return inOrder;
    }
}
