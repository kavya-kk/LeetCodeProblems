package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
public class MaxDepthOfNaryTree {
    public static void main(String[] str){
        Node six = new Node(6,null);
        Node five = new Node(5,null);
        Node two = new Node(2,null);
        Node four = new Node(4,null);
        List<Node> children3 = new ArrayList<>();
        children3.add(five);
        children3.add(six);
        Node three = new Node(3, children3);
        List<Node> children1 = new ArrayList<>();
        children1.add(three);
        children1.add(two);
        children1.add(four);
        Node one = new Node(1, children1);
        System.out.println(maxDepth(one));
    }
    public static int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        if(root.children == null || root.children.isEmpty()){
            return 1;
        }
        int depth = Integer.MIN_VALUE;
        for(Node child: root.children){
            depth = Math.max(depth,maxDepth(child)+1);
        }
        return depth;
    }

     static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
