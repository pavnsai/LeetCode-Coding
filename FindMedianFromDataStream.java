import java.util.ArrayList;
import java.util.List;

public class FindMedianFromDataStream {
    List<Integer> list;
    public FindMedianFromDataStream() {
        list=new ArrayList<Integer>();
    }

    public void addNum(int num) {
        if(list.size()>0){
            int i=0;
            for( i=0;i<list.size();i++){
                if(list.get(i)<num){
                    continue;
                }else{
                    break;
                }
            }
            list.add(i,num); // This has to be here
        }
        else{
            list.add(num);
        }
    }

    public double findMedian() {
        int middle=list.size()/2;
        if(list.size()%2==0){
            return (double)(list.get(middle)+list.get(middle-1))/2;
        }else{
            return list.get(middle);
        }
    }
}

// Can use Binary Search for searching as it is sorted list
class FindMedianFromDataStreamBinarySearch {
    List<Integer> list;
    public FindMedianFromDataStreamBinarySearch() {
        list=new ArrayList<Integer>();
    }
    public int binarySearch(int low,int high,int num){
        if(low<=high){
            int mid=low+(high-low)/2;
            int val=list.get(mid);
            if(val==num){
                return mid;
            }
            else if(val>num){
                return binarySearch(low,mid-1,num);
            }else{
                return binarySearch(mid+1,high,num);
            }
        }
        return high+1;
    }
    public void addNum(int num) {
        int idx=binarySearch(0,list.size()-1,num);
        list.add(idx,num);
    }

    public double findMedian() {
        int middle=list.size()/2;
        if(list.size()%2==0){
            return (double)(list.get(middle)+list.get(middle-1))/2;
        }else{
            return list.get(middle);
        }
    }
}
