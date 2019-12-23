package leetcode.problems.LinkedList;

public class RemoveNthNodeFromEnd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] str){
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(10);

        ListNode l =removeNthFromEnd(l1,2);
        while(l!=null){
            System.out.println(l.val);
            l=l.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 2 pointers
        ListNode fast = head, slow = head;
        // fast pointer moves n nodes
        while(n>1){
            fast = fast.next;
            n--;
        }
        // slow and fast pointers move together until fast reaches the last node
        ListNode temp = null;
        while(fast.next !=null){
            fast = fast.next;
            temp = slow;
            slow =slow.next;
        }

        // remove the node pointed by slow;
        // one node in the list and n=1;
        if(slow.next == null && temp == null){
            return null;
        }
        // n nodes int the list
        else if (temp == null){
            return slow.next;
        }
        temp.next = slow.next;
        return head;
    }
}
