package leetcode.problems.Tree;
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class PopulatingNextRightPointersII {

    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        if(root.left!=null){
            root.left.next = processAndGet(root,true);
        }
        if(root.right!=null){
            root.right.next = processAndGet(root,false);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node processAndGet(Node root, boolean isLeft){
        if(isLeft && root.right!=null){
            return root.right;
        }
        Node cur = root.next;
        while(cur !=null){
            if(cur.left !=null){
                return cur.left;
            }else if (cur.right!=null){
                return cur.right;
            }
            cur = cur.next;
        }
        return null;
    }
}
