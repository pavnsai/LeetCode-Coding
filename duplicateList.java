import java.util.ArrayList;
import java.util.List;

public class duplicateList {
    public static int duplicateCount(int [] arr){
        List<Integer> li=new ArrayList<>();
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(li.contains(arr[i])){
                count++;
            }else{
                li.add(arr[i]);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[]=new int[]{1,2,2,3,3};
        System.out.println(duplicateCount(arr));
    }
}


// Car (vehicle model, rc number etc
// duration Vehicle,timein , timeout, position
// Price

// register + /pricecalcultor+ duration extension + /timeout

//Car,
//duration

//@RestController
//@PostMethod
//Database class

//registerController
//registerService
//RegisterDao


