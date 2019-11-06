package leetcode.problems;

import nodes.LinkedListNode;

public class CopyLinkedListWithRandomPtrs {
    public static void main(String[] s){
        LinkedListNode two = new LinkedListNode(2);
        LinkedListNode three = new LinkedListNode(3);
        LinkedListNode four = new LinkedListNode(4);
        two.next = three;
        two.random = two;
        three.next = four;
        three.random = two;
        four.random = three;
        four.next = null;
        LinkedListNode head = two;
        LinkedListNode newHead = deepCopy(head);
        LinkedListNode temp = head;
        while(temp!=null){
            System.out.println("Node "+temp.val);
            if(temp.next!=null)
                System.out.println("Next is"+ temp.next.val);
            if(temp.random!=null)
                System.out.println("Random is"+ temp.random.val);
            temp = temp.next;
        }
    }

    public static LinkedListNode deepCopy(LinkedListNode head){
        if(head == null){
            return null;
        }
        // copy the nodes adjacent to the parent linkedlist nodes.
        LinkedListNode temp = head;
        while(temp!=null){
            temp.next = new LinkedListNode(temp.val,temp.next);
            temp = temp.next.next;
        }
        // copy random pointers
        temp = head;
        while(temp!=null){
            if(temp.random!= null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        // detach
        LinkedListNode t1 = head.next, newHead = t1;
        temp = head;

        while (temp!=null && temp.next!=null){
            temp.next = t1.next;
            if(temp.next!= null){
            t1.next = temp.next.next;}
            temp = temp.next;
            t1 = t1.next;
        }

        return newHead;
    }
}
