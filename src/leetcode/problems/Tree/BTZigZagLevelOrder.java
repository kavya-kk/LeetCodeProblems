package leetcode.problems.Tree;

import nodes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTZigZagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelLength = q.size();
            List<Integer> levelList = new ArrayList<>();
            res.add(levelList);
            for(int i =0;i<levelLength;i++){
                TreeNode node = q.poll();
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                if(level%2 == 0){
                    levelList.add(node.val);
                }else {
                    levelList.add(0,node.val);
                }
            }
            level++;
        }
        return res;
    }
}
