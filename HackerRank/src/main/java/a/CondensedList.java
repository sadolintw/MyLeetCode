//import java.util.*;
//import java.util.stream.Collectors;
//
//class Result {
//
//    /*
//     * Complete the 'condense' function below.
//     *
//     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
//     * The function accepts INTEGER_SINGLY_LINKED_LIST head as parameter.
//     */
//
//    /*
//     * For your reference:
//     *
//     * SinglyLinkedListNode {
//     *     int data;
//     *     SinglyLinkedListNode next;
//     * }
//     *
//     */
//
//    public static SinglyLinkedListNode condense(SinglyLinkedListNode head) {
//        // Write your code here
//        if(head == null){
//            return null;
//        }
//
//        LinkedHashMap<Integer, SinglyLinkedListNode> store = new LinkedHashMap<>();
//
//        SinglyLinkedListNode copy = head;
//
//        while(copy != null){
//            SinglyLinkedListNode temp = copy;
//            store.put(temp.data, temp);
//            copy = copy.next;
//        }
//
//        List<Integer> storeList = store.keySet().stream().collect(Collectors.toList());
//
//        SinglyLinkedListNode newhead = store.get(storeList.get(0));
//        SinglyLinkedListNode newheadcopy = newhead;
//
//        for(int i = 0 ; i < storeList.size()-1 ; i++){
//
//            newhead.next = store.get(storeList.get(i+1));
//            newhead = newhead.next;
//        }
//        newhead.next = null;
//
//        return newheadcopy;
//    }
//}
//
//class SinglyLinkedListNode {
//    public int data;
//    public SinglyLinkedListNode next;
//    SinglyLinkedListNode() {}
//    public SinglyLinkedListNode(int data) { this.data = data; }
//    public SinglyLinkedListNode(int data, SinglyLinkedListNode next) { this.data = data; this.next = next; }
//    public static SinglyLinkedListNode convertToListNode(String number){
//        SinglyLinkedListNode listNode = null;
//        for(char item : number.toCharArray()){
//            int num = Integer.valueOf(item+"");
//            if(listNode == null){
//                listNode = new SinglyLinkedListNode(num);
//            }else{
//                listNode = new SinglyLinkedListNode(num, listNode);
//            }
//        }
//        return listNode;
//    }
//    public static SinglyLinkedListNode convertToListNode(int[] numbers){
//        List<Integer> list = Arrays.stream( numbers ).boxed().collect( Collectors.toList() );
//        Collections.reverse(list);
//        SinglyLinkedListNode listNode = null;
//        for(int i = 0 ; i < numbers.length ; i++){
//            int num = (int) list.get(i);
//            if(listNode == null){
//                listNode = new SinglyLinkedListNode(num);
//            }else{
//                listNode = new SinglyLinkedListNode(num, listNode);
//            }
//        }
//        return listNode;
//    }
//}
//
//public class CondensedList {
//    public static void main(String[] args) {
//        int[] head = {8,3,4,3,2,6,1,2,6};
//        SinglyLinkedListNode list = SinglyLinkedListNode.convertToListNode(head);
//        Result.condense(list);
//    }
//}
