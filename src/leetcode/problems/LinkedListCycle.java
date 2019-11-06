package leetcode.problems;

public class LinkedListCycle {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] s){
        ListNode l1 = new ListNode(1);
        l1.next = l1;
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(1);
//        l1.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next = l1.next;
        //l1.next.next.next.next.next.next = new ListNode(1);

        System.out.println(detectCycle(l1));

    }
    private static boolean detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast !=null &&  fast.next!= null && slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == fast){
            return true;
        }
        return false;
    }


}
