package nodes;

public class LinkedListNode {
    public int val ;
    public LinkedListNode next = null;
    public LinkedListNode random = null;

    public LinkedListNode(int val){
        this.val = val;
    }
    public LinkedListNode(int val, LinkedListNode next){
        this.val = val;
        this.next = next;
    }
}
