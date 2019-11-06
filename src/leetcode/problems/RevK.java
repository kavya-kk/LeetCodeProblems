package leetcode.problems;

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

    private static ListNode reverseKGroup(ListNode head, int k){

        if(k==1 || head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        int cnt = 0;
        while(cnt <=k) {
            temp = temp.next;
            cnt++;
            if(temp == null){
                break;
            }
        }
        if(cnt<k){
            return head;
        }
        ListNode prev = head;
        ListNode cur = prev.next;
        ListNode next = cur.next;
        int ki=1;
        while (ki<k){
            cur.next = prev;
            ki++;

            prev = cur;
            cur= next;
            if(cur == null){
                break;
            }
            next = next.next;
        }
        head.next = reverseKGroup(cur, k);
        return prev;
    }
}
