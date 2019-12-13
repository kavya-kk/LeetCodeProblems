package leetcode.problems.LinkedList;

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
        if(lists.length ==0){
            return null;
        }
        return helper(lists,0,lists.length-1);
    }

    private static ListNode helper(ListNode[] lists, int start, int end){
        if(end-start == 1){
            return merge2Lists(lists[start],lists[end]);
        }else if(start == end){
            return lists[end];
            // do nothing; since the merged list will already be at start idx;
        }
        int mid = (start+end)/2;

        ListNode l1= helper(lists,start,mid);
        ListNode l2 = helper(lists,mid+1,end);

        return merge2Lists(l1,l2);
    }

    private static ListNode merge2Lists(ListNode l1, ListNode l2){

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode nH = l1.val<l2.val? l1:l2;
        ListNode p1=l1, p2=l2, t1=null,t2 = null;
        while(p2!=null){
            if(p1!=null && p2.val<=p1.val){
                // p2<=p1 so attach p2 in front of p1;
                if(t1==null){
                    t1 = p2;
                }else{
                    t1.next = p2;
                }
                t2 = p2.next;
                p2.next =p1;
                t1 = p2;
                p2 =t2;
            }else {
                // p2>p1 so move to correct position on p1;
                if(p1!=null){
                    t1 = p1;
                    p1 = p1.next;
                }else {
                    break;
                }
            }
        }

        if(p1 == null && p2!=null){
            t1.next = p2;
        }
        return nH;
    }
}
