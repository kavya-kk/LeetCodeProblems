package leetcode.problems.LinkedList;

public class RemoveDupList2 {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] s){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(1);
        l1.next.next.next.next = new ListNode(1);
        l1.next.next.next.next.next = new ListNode(1);
        l1.next.next.next.next.next.next = new ListNode(1);

        ListNode l =deleteDuplicates(l1);
        while(l!=null){
            System.out.println(l.val);
            l=l.next;
        }
    }
    private static ListNode deleteDuplicates(ListNode head) {
        if(head ==null || head.next ==null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        while(next!=null){
            if(cur.val != next.val){
                prev = cur;
                cur = next;
                next = next.next;
            }else {
                while (next!=null && cur.val == next.val) {
                    cur = cur.next;
                    next = next.next;
                }
                if (prev == null) {
                    head = next;
                    if (head == null) {
                        return null;
                    }
                    cur = next;
                    next = next.next;
                } else {
                    prev.next = next;
                    if(next!=null) {
                        cur = next;
                        next = next.next;
                    }
                }
            }
        }
        return head;
    }


}
