package medium.N0142;

import vo.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while(head != null){
            if(nodesSeen.contains(head)){
                return head;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return null;
    }
}

public class N0142_Linked_List_Cycle_II {
    public static void main(String[] args) {
        int[] head = {3,2,0,-4};
        int pos = 1;
        ListNode list = ListNode.convertToListNode(head);

        ListNode headNode = list;
        ListNode posNode = null;
        int index = 0;
        while(headNode.next!=null){
            if(index == pos){
                posNode = headNode;
            }
            headNode = headNode.next;
            index++;
        }
        headNode.next = posNode;

        Solution solution = new Solution();
        solution.detectCycle(list);
    }
}
