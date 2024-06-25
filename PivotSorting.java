//public class PivotSorting {
//    int pivot=6;
//    TreeNode list,before=null,tempBefore=before,after=null,tempAfter=after,temp=list;
//    while(temp!=null){
//        if(temp.val<pivot){
//            if(before==null) {
//                tempBefore=before;
//                before = temp;
//            }else{
//                before.next=temp;
//                before=before.next;
//            }
//        }else if(temp.val>pivot){
//            if(after==null) {
//                tempAfter=after;
//                after = temp;
//            }else{
//                after.next=temp;
//                after=after.next;
//            }
//        }else{
//            countPivot++;
//        }
//        temp=temp.next;
//    }
//    TreeNode finalAns;
//    if(!equal){
//        equal.next=after;
//        finalAns=tempEqual;
//        if(!before){
//            before.next=equal;
//            finalAns=tempBefore;
//        }
//    }
//
//    if(!before)
//    {
//        before.next = tempAfter;
//    }
//    else if(!equal){
//
//    }else{
//
//    }
//
//    return tempBefore;
//}
//
//
//Original list
//
//3->7->9->19->9->12->2
//
////bfore 3 7 2 9 9
////after 19 12
//Pivot: 9
//Output: 3->7->2->9->19->12
//
//Pivot : 5
//Output: 3->2->7->9->19->12