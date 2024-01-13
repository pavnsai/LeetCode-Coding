import java.util.ArrayList;

public class ArraySubsequencesPrintRecursion {
    static void print(int idx, ArrayList<Integer> al,int arr[], int n){
        if(idx==n){
            for(Integer num:al){
                System.out.print(num+" ");
            }
            System.out.println("");
            return;
        }
        al.add(arr[idx]);
        print(idx+1,al,arr,n);
        al.remove(Integer.valueOf(arr[idx]));
        print(idx+1,al,arr,n);
    }

    public static void main(String[] args) {
        int arr[]={3,1,2};
        print(0,new ArrayList<Integer>(),arr,3);
    }
}
