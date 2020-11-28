package vo;

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
}
