package leetcode.problems.Tree;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointers {

    public Node connect(Node root) {
        helper(root);
        return root;
    }

    private void helper(Node root){
        if(root == null){
            return;
        }
        if(root.left!=null){
            root.left.next = root.right;
        }
        if(root.right!=null){
            root.right.next = root.next == null? null : root.next.left;
        }
        helper(root.right);
        helper(root.left);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
