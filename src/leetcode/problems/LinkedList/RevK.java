package leetcode.problems.LinkedList;

public class RevK {

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
        l1.next.next.next = new ListNode(12);
        l1.next.next.next.next = new ListNode(14);
        l1.next.next.next.next.next = new ListNode(21);
        l1.next.next.next.next.next.next = new ListNode(2);

        ListNode l =reverseKGroup(l1,3);
        while(l!=null){
            System.out.println(l.val);
            l=l.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k <=1){
            return head;
        }

        ListNode result = null;
        ListNode cur = head;
        ListNode prev = null;
        while(cur!=null){
            //start - beginning of the group of k nodes that are to be reversed;
            // end - marks the end of the group of k nodes that are to be reversed;
            ListNode start = cur, end = null;
            //to maintain the current count in the group.
            int kIdx = 0;
            // gather the group of k nodes;
            while(kIdx<k && cur!=null){
                end = cur;
                cur = cur.next;
                kIdx++;
            }
            // if there are k nodes available to be reversed;
            if(kIdx == k){
                // the reverse helper function returns head of the reversed section;
                ListNode reversedHead = reverse(start,end);
                // if the final result list's head is not defined assign the reversed head to it, and keep track of the last node to attach the next reversed group's head.
                if(result == null){
                    result = reversedHead;
                    prev = start;
                }
                // if the result head is already defined, attach the currently reversed group's head to the previously reversed group's last node.
                else {
                    prev.next = reversedHead;
                    prev = start;
                }
            }
            // if there are no k nodes in the group then attach them as it is (without reversing)
            else {
                if(prev !=null)
                    prev.next = start;
            }

        }
        return result == null? head: result;
    }

    // a helper function to reverse the nodes from start to end;
    private static ListNode reverse(ListNode start, ListNode end){
        ListNode prev = start;
        ListNode cur = start.next;
        ListNode next = cur.next;
        while(cur!=end){
            cur.next = prev;

            prev = cur;
            cur = next;
            next =next.next;
        }

        cur.next = prev;
        start.next = null;
        return cur;
    }
}
