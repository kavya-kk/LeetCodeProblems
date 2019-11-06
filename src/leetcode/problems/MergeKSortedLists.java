package leetcode.problems;

public class MergeKSortedLists {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void main(String[] s){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(6);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(1);
        l3.next.next = new ListNode(3);

        ListNode[] arr = {l1,l2,l3};

        ListNode l =mergeKLists(arr);

        while(l!=null){
            System.out.print(l.val+"  ");
            l=l.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = lists[0];
        for (int i =1;i<lists.length; i++){
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
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
