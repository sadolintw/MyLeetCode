package util.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode convertToListNode(String number){
        ListNode listNode = null;
        for(char item : number.toCharArray()){
            int num = Integer.valueOf(item+"");
            if(listNode == null){
                listNode = new ListNode(num);
            }else{
                listNode = new ListNode(num, listNode);
            }
        }
        return listNode;
    }
    public static ListNode convertToListNode(int[] numbers){
        List<Integer> list = Arrays.stream( numbers ).boxed().collect( Collectors.toList() );
        Collections.reverse(list);
        ListNode listNode = null;
        for(int i = 0 ; i < numbers.length ; i++){
            int num = (int) list.get(i);
            if(listNode == null){
                listNode = new ListNode(num);
            }else{
                listNode = new ListNode(num, listNode);
            }
        }
        return listNode;
    }
}
