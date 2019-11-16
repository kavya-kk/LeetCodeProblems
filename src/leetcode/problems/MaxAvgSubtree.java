package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class MaxAvgSubtree {
    static float curMaxAvg = Float.MIN_VALUE;
    public static void main(String[] s){
        Node eleven = new Node(11,null);
        Node three = new Node(3,null);
        Node two = new Node(2,null);
        Node fifteen = new Node(15,null);
        Node eight = new Node(8,null);
        List<Node> children12 = new ArrayList<>();
        children12.add(eleven);
        children12.add(two);
        children12.add(three);
        Node twelve = new Node(12, children12);
        List<Node> children18 = new ArrayList<>();
        children18.add(fifteen);
        children18.add(eight);
        Node eighteen = new Node(18,children18);
        List<Node> children20 = new ArrayList<>();
        children20.add(twelve);
        children20.add(eighteen);
        Node one = new Node(20, children20);

        Node res = maxAvgSubTree(one);
        System.out.println(res.val+" Max Avg"+ res.avg);
    }
    private static Node maxAvgSubTree(Node root) {
        if (root == null) {
            return null;
        }
        if(root.children == null || root.children.isEmpty()){
            root.avg = root.val;
            return null;
        }
        Node curMaxRoot = root;
        float sum = root.val;
        for (Node child:
                root.children) {
            Node res = maxAvgSubTree(child);
            sum +=child.avg;
            curMaxRoot = res == null? curMaxRoot:res;
        }
        root.avg = sum / (root.children.size()+1);
        if(curMaxAvg<root.avg){
            curMaxAvg = root.avg;
            curMaxRoot = root;
        }
        return curMaxRoot;
    }
    static class Node {
        public int val;
        public List<Node> children;
        public float avg;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
