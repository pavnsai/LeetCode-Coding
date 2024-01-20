import java.util.ArrayList;
//TLE 1
 class MaximumSumOfNonAdjacentElementsTLE1 {
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
        sum(0,nums,nums.size(),0,arr);
        return arr[0];
    }
}
//TLE2
 class MaximumSumOfNonAdjacentElementsTLE2 {
     public static int sum(int idx,ArrayList<Integer> nums,
                           int n,int arr[]){
         if(idx>=n){
             return 0;
         }
         int pick=nums.get(idx)+sum(idx+2,nums,n,arr);
         int notPick=sum(idx+1,nums,n,arr);
         return Math.max(pick,notPick);
     }
     public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
         // Write your code here.
         int arr[]={Integer.MIN_VALUE};
         int ans[]=new int[nums.size()];
         return sum(0,nums,nums.size(),arr);
     }
}