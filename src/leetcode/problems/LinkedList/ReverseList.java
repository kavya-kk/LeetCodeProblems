package leetcode.problems.LinkedList;

public class ReverseList {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] s){
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(10);

        ListNode l =reverse(l1);
        while(l!=null){
            System.out.println(l.val);
            l=l.next;
        }
    }

    private static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = head;
        ListNode cur = prev.next;
        ListNode next = cur.next;

        while (next!= null){
            cur.next = prev;

            prev = cur;
            cur = next;
            next = next.next;
        }

        cur.next = prev;
        head.next = null;
        head = cur;
        return head;
    }
}
