package leetcode.problems;

public class Merge2SortedLists {

    //      Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void  main(String[] st){
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(10);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(4);
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
        ListNode nH = null;
        ListNode temp=null;
        while(l1!=null && l2!=null){
            if(l1.val  < l2.val){
                if(nH ==null){
                    nH = l1;
                }else if (temp != null){
                    temp.next = l1;
                }
                while(l1 !=null && l1.val < l2.val ){
                    temp = l1;
                    l1 =l1.next;
                }
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }else if(l2.val  <= l1.val){
                if(nH ==null){
                    nH = l2;
                }else if (temp!= null){
                    temp.next =l2;
                }
                while(l2 !=null && l2.val <= l1.val ){
                    temp = l2;
                    l2 =l2.next;
                }
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }
        }
        if(l1 == null && l2 !=null){
            temp.next =l2;
        }else if (l1!=null && l2 == null){
            temp.next = l1;
        }

        return nH;
    }
}
