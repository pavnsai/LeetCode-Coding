public class MinimumOperations3191 {
    public int minOperations(int[] nums) {
        int n=nums.length,ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                if(i+2>=n){
                    return -1;
                }
                ans++;
                int k=i;
                while(k<n && k<=i+2){
                    nums[k]=1-nums[k];
                    k++;
                }
            }
        }
        return ans;
    }
}
