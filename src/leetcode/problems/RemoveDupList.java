package leetcode.problems;

public class RemoveDupList {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] s){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(1);
//        l1.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next = new ListNode(1);

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
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur!=null){
            while(prev.val == cur.val){
                if(cur.next!=null){
                    cur = cur.next;
                }else {
                    break;
                }
            }
            if(prev.val ==cur.val && cur.next == null){
                prev.next = null;
                return head;
            }else {
                prev.next = cur;
                cur= cur.next;
                prev = prev.next;
            }
        }
        return head;
    }


}
