class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeKSortedLists {

    public ListNode merge(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode start=new ListNode(0,null);
        ListNode store=start;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                start.next=list1;
                list1=list1.next;
            }else{
                start.next=list2;
                list2=list2.next;
            }
            start=start.next;
        }
        if(list1==null){
            start.next=list2;
        }else{
            start.next=list1;
        }
        return store.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans=null;
        for(int i=0;i<lists.length;i++){
            ans=merge(ans,lists[i]);
        }
        return ans;
    }
}

// Efficient Approach

class MergeKSortedListsEfficient {

    public ListNode merge(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode start=new ListNode(0,null);
        ListNode store=start;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                start.next=list1;
                list1=list1.next;
            }else{
                start.next=list2;
                list2=list2.next;
            }
            start=start.next;
        }
        if(list1==null){
            start.next=list2;
        }else{
            start.next=list1;
        }
        return store.next;
    }
    public ListNode mergeSort(ListNode lists[], int low,int high){
        if(low==high){
            return lists[low];
        }
        int mid=low+(high-low)/2;
        ListNode lf=mergeSort(lists,low,mid);
        ListNode rf=mergeSort(lists,mid+1,high);
        return merge(lf,rf);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans=null;
        if(lists.length==0){
            return null;
        }
        return mergeSort(lists,0,lists.length-1);
    }
}
