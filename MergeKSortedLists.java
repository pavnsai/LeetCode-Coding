public class MergeKSortedLists {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode merge(ListNode[] lists,int a, int b){
        ListNode list1=lists[a];
        ListNode list2=lists[b];
        ListNode ans=new ListNode(0);
        ListNode realAns=ans;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                realAns.next=list1;
                list1=list1.next;
                realAns=realAns.next;
            }else{
                realAns.next=list2;
                list2=list2.next;
                realAns=realAns.next;
            }
        }
        if(list1!=null){
            realAns.next=list1;
        }
        if(list2!=null){
            realAns.next=list2;
        }
        return ans.next;
    }

    public ListNode merge2(ListNode list1, ListNode list2){
        ListNode ans=new ListNode(0);
        ListNode realAns=ans;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                realAns.next=list1;
                list1=list1.next;
                realAns=realAns.next;
            }else{
                realAns.next=list2;
                list2=list2.next;
                realAns=realAns.next;
            }
        }
        if(list1!=null){
            realAns.next=list1;
        }
        if(list2!=null){
            realAns.next=list2;
        }
        return ans.next;
    }
    public ListNode mergeSort(ListNode[] lists,int a,int b){
        if(a==b){
            return lists[a];
        }
        int mid=a+(b-a)/2;
        ListNode left=mergeSort(lists,a,mid);
        ListNode right=mergeSort(lists,mid+1,b);
        return merge2(left,right);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }

        //Solution 2

        // ListNode[] finals=lists;
        // while(finals.length!=1){
        //     int k=0;
        //     ListNode[] temp=new ListNode[(finals.length+1)/2];
        //     for(int i=0;i<finals.length-1;i=i+2){
        //         temp[k++]=merge(finals,i,i+1);
        //     }
        //     if(finals.length%2==1){
        //         temp[k]=finals[finals.length-1];
        //     }
        //     finals=temp;
        // }
        // return finals[0];
        return mergeSort(lists,0,lists.length-1);
    }
}
