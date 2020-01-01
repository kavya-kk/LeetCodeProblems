package leetcode.problems.LinkedList;

import nodes.ListNode;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null ){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode res = null, temp = null;

        int reminder = 0;
        while(l1 != null && l2 !=null){
            int sum = l1.val + l2.val + reminder;
            reminder =0;
            if(sum >=10){
                reminder = sum/10;
                sum  = sum%10;
            }

            if(temp ==null){
                res = temp =  new ListNode(sum);
            }else {
                temp.next =  new ListNode(sum);
                temp = temp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        // should add remaining digits to the list.
        if(l1 == null)
            appendRemaining(l2,temp,reminder);
        else
            appendRemaining(l1,temp,reminder);

        return res;
    }

    private void appendRemaining(ListNode l1, ListNode result, int reminder){
        while(l1!=null){
            int sum = reminder+l1.val;
            reminder =0;
            if(sum >=10){
                reminder = sum/10;
                sum  = sum%10;
            }
            result.next =  new ListNode(sum);
            result = result.next;
            l1=l1.next;
        }

        if(reminder!=0){
            result.next = new ListNode(reminder);
        }
    }
}
