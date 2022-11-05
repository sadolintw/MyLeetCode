package medium.N0002;

import util.vo.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode head, current;
        head = new ListNode(0);
        current = head;
        int carry = 0;
        while(list1 != null || list2 != null){
            int sum = 0;

            if( list1 != null ){
                sum += list1.val;
                list1 = list1.next;
            }

            if( list2 != null ){
                sum += list2.val;
                list2 = list2.next;
            }

            sum+=carry;
            carry = sum/10;
            sum = sum%10;

            current.next = new ListNode(sum);
            current = current.next;
        }
        if(carry != 0){
            current.next = new ListNode(carry);
        }

        return head.next;
    }
}

//////////////////////////////////////////////////////////////////

public class N0002_Add_Two_Numbers {

    public static void main(String[] args){
        String number1 = "123";
        ListNode listNode1 = ListNode.convertToListNode("342");
        ListNode listNode2 = ListNode.convertToListNode("465");
        ListNode listNode3 = new Solution().addTwoNumbers(listNode1, listNode2);
        System.out.println("hi");
        //System.out.println(Arrays.toString(solution.addTwoNumbers(nums, 5)));
    }
}
