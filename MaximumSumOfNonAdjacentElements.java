import java.util.ArrayList;

public class MaximumSumOfNonAdjacentElements {
    public static void sum(int idx, ArrayList<Integer> nums,
                           int n, int sum, int arr[]){
        if(idx>=n){
            arr[0]=Math.max(arr[0],sum);
            return;
        }
        sum(idx+2,nums,n,sum+nums.get(idx),arr);
        sum(idx+1,nums,n,sum,arr);
    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int arr[]={Integer.MIN_VALUE};
        int ans[]=new int[nums.size()];
        sum(0,nums,nums.size(),0,arr);
        return arr[0];
    }
}
