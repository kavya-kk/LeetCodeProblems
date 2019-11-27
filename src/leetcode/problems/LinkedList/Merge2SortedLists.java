package leetcode.problems.LinkedList;

public class Merge2SortedLists {

    //      Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void  main(String[] st){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(10);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        l2.next.next.next.next = new ListNode(4);

        ListNode l =mergeTwoLists(l1,l2);
        while(l!=null){
            System.out.println(l.val);
            l=l.next;
        }

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // if either of the lists are empty
        if(l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }
        ListNode t1= l1, t2 = l2, hRes = null,temp=null;
        while(t1!=null && t2!=null){
            if(t1.val <= t2.val){
                if(hRes== null){
                    hRes = t1;
                }
                while(t1!=null && t1.val <=t2.val){
                    temp = t1;
                    t1 = t1.next;
                }
                temp.next = t2;
            }else {
                if(hRes== null){
                    hRes = t2;
                }
                while(t2!=null && t2.val <= t1.val){
                    temp = t2;
                    t2 = t2.next;
                }
                temp.next = t1;
            }
        }
        return hRes;
    }
}
