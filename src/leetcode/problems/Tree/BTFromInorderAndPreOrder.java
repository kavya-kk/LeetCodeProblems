package leetcode.problems.Tree;

import nodes.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BTFromInorderAndPreOrder {

    private Map<Integer,Integer> itemIndices = new HashMap<>();
    private int rootIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0;i<inorder.length;i++){
            itemIndices.put(inorder[i],i);
        }
        return buildTree(preorder,inorder,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] preOrder,int[] inorder, int s, int e){
        if(rootIndex >= preOrder.length || s < 0 || e>=inorder.length){
            return null;
        }
        int val = preOrder[rootIndex++];
        TreeNode root = new TreeNode(val);
        int inorderIdx = itemIndices.get(val);
        if(s<e){
            if(s <= inorderIdx-1){
                root.left = buildTree(preOrder,inorder,s,inorderIdx-1);
            }
            if(e >= inorderIdx+1)
                root.right = buildTree(preOrder,inorder,inorderIdx+1,e);
        }
        return root;
    }
}
