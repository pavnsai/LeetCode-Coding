import java.util.Arrays;

class PartitionEqualSubsetSUmTLE {
     public boolean check(int idx,int sum,int[] nums){
         if(sum==0){
             return true;
         }
         if(sum<0){
             return false;
         }
         if(idx==0){
             return (sum==nums[0]);
         }
         boolean chk1=check(idx-1,sum-nums[idx],nums);
         boolean chk2=check(idx-1,sum,nums);
         return chk1||chk2;

     }
     public boolean canPartition(int[] nums) {
         int sum=0,n=nums.length;
         for(int i=0;i<nums.length;i++){
             sum+=nums[i];
         }
         if(sum%2==1){
             return false;
         }
         return check(n-1,sum/2,nums);
     }
}

 class PartitionEqualSubsetSUmMemoization {
     public boolean check(int idx,int sum,int[] nums,Boolean[][] ans){
         if(sum==0){
             return true;
         }
         if(sum<0){
             return false;
         }
         if(idx==0){
             return (sum==nums[0]);
         }
         if(ans[idx][sum]!=null){
             return ans[idx][sum];
         }
         boolean chk1=check(idx-1,sum-nums[idx],nums,ans);
         boolean chk2=check(idx-1,sum,nums,ans);
         return ans[idx][sum]=chk1||chk2;

     }
     public boolean canPartition(int[] nums) {
         int sum=0,n=nums.length;
         for(int i=0;i<nums.length;i++){
             sum+=nums[i];
         }
         if(sum%2==1){
             return false;
         }
         sum=sum/2;
         Boolean ans[][]=new Boolean[n][sum+1];
         for(int i=0;i<n;i++){
             Arrays.fill(ans[i],null);
         }
         return check(n-1,sum,nums,ans);
     }
 }

class PartitionEqualSubsetSUmDP {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;
        boolean ans[][] = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            ans[i][0] = true;
        }
        if (nums[0] <= sum) {
            ans[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean chk1 = false;
                if (j - nums[i] >= 0) {
                    chk1 = ans[i - 1][j - nums[i]];
                }
                boolean chk2 = ans[i - 1][j];
                ans[i][j] = chk1 || chk2;
            }
        }
        return ans[n - 1][sum];
    }
}