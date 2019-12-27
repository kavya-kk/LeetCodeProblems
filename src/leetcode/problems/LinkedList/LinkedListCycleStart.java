package leetcode.problems.LinkedList;

import nodes.ListNode;

public class LinkedListCycleStart {

    public static void main(String[] s){
        ListNode l1 = new ListNode(1);
        l1.next = l1;
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(1);
        l1.next.next.next.next = new ListNode(1);
        l1.next.next.next.next.next = l1.next;
        l1.next.next.next.next.next.next = new ListNode(1);

        System.out.println(detectCycle(l1));

    }

    public static ListNode detectCycle(ListNode head) {
        if(head ==null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        //detect cycle.
        do{
            slow = slow.next;
            if(fast.next==null)
                break;
            fast = fast.next.next;
        }while(fast!=null && fast != slow);

        if(fast == null || fast.next==null){
            return null;
        }

        ListNode ptr = head;
        while(ptr!=slow){
            ptr= ptr.next;
            slow = slow.next;
        }

        return slow;
    }
}
