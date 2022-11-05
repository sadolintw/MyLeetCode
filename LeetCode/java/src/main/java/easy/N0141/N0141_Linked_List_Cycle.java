package easy.N0141;

import util.vo.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while(head != null){
            if(nodesSeen.contains(head)){
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }
}

public class N0141_Linked_List_Cycle {
    public static void main(String[] args) {
        Solution solution = new Solution();
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

        System.out.println(solution.hasCycle(list));
    }
}
