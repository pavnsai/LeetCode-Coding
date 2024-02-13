import java.util.Arrays;

//TLE
class LongestIncreasingSubsequenceTLE {
     public int check(int i,int prev,int nums[]){
         if(i==nums.length){
             return 0;
         }
         if(prev==-1||nums[prev]<nums[i]){
             return Math.max(1+check(i+1,i,nums),check(i+1,prev,nums));
         }else{
             return check(i+1,prev,nums);
         }
     }
     public int lengthOfLIS(int[] nums) {
         int n=nums.length;
         return check(0,-1,nums);
     }
}

//Memoization
class LongestIncreasingSubsequenceMemoization {
    public int check(int i,int prev,int nums[],int ans[][]){
        if(i==nums.length){
            return 0;
        }
        if(ans[i][prev+1]!=-1){
            return ans[i][prev+1];
        }
        if(prev==-1||nums[prev]<nums[i]){
            return ans[i][prev+1]=Math.max(1+check(i+1,i,nums,ans),check(i+1,prev,nums,ans));
        }else{
            return ans[i][prev+1]=check(i+1,prev,nums,ans);
        }
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int ans[][]=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(0,-1,nums,ans);
    }
}

//DP
class LongestIncreasingSubsequenceDP {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int ans[][]=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                if(prev==-1||nums[prev]<nums[i]){
                    ans[i][prev+1]=Math.max(1+ans[i+1][i+1],ans[i+1][prev+1]);
                }else{
                    ans[i][prev+1]=ans[i+1][prev+1];
                }
            }
        }
        return ans[0][0];
    }
}

//DP2
class LongestIncreasingSubsequenceDP2 {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int forw[]=new int[n+1];
        int curr[]=new int[n+1];
        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                if(prev==-1||nums[prev]<nums[i]){
                    curr[prev+1]=Math.max(1+forw[i+1],forw[prev+1]);
                }else{
                    curr[prev+1]=forw[prev+1];
                }
            }
            forw=Arrays.copyOf(curr,curr.length);
        }
        return curr[0];
    }
}

//DP3
class LongestIncreasingSubsequenceDP3 {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        dp[0]=1;
        int res=1;
        for(int i=1;i<n;i++){
            int ans=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    ans=Math.max(ans,dp[j]+1);
                }
            }
            dp[i]=ans;
            res=Math.max(res,ans);
        }
        return res;
    }

}