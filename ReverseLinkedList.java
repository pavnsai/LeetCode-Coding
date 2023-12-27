public class ReverseLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseList(ListNode head) {
        ListNode temp=null,temp2=head,headTemp=head;
        while(headTemp!=null){
            temp2=headTemp.next;
            headTemp.next=temp;
            temp=headTemp;
            headTemp=temp2;
        }
        return temp;
    }
}
