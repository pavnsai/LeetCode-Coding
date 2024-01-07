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
