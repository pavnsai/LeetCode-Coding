public class RemoveNNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        if(head==null)
            return head;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int traversalCount=count-n-1;
        temp=head;
        while(traversalCount>0){
            temp=temp.next;
            traversalCount--;
        }

         if(count==n){
            head=head.next;
        }else{
            temp.next=temp.next.next;
        }
        return head;
    }
    //Second Approach
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
