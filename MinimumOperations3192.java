public class MinimumOperations3192 {
    public int minOperations(int[] nums) {
        int n=nums.length,ans=0;
        for(int i=0;i<n;i++){
            if(ans%2==0){
                if(nums[i]==0){
                    ans++;
                }
            }else{
                if(nums[i]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
