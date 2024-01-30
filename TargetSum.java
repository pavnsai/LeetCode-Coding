import java.util.Arrays;

public class TargetSum {
    public int check(int idx,int nums[],int target){
        if(idx==0){
            if(target==0&&nums[0]==0){
                return 2;
            }
            if(target-nums[idx]==0||target+nums[idx]==0){
                return 1;
            }
            return 0;
        }
        int left=check(idx-1,nums,target-nums[idx]);
        int right=check(idx-1,nums,target+nums[idx]);
        return left+right;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return check(n-1,nums,target);
    }
}

// as s1-s2=d where s2 is all negatives // so we can just check for sum (total-d)/2 or (total+d)/2

 class TargetSum2 {
    public int check(int idx, int nums[], int target) {
        if(target<0){
            return 0;
        }
        if (idx == 0) {
            if (target == 0 && nums[0] == 0) {
                return 2;
            }
            if (nums[0] == target || target == 0) {
                return 1;
            }
            return 0;
        }
        int left = check(idx - 1, nums, target - nums[idx]);
        int right = check(idx - 1, nums, target);
        return left + right;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (((sum + target) % 2) == 1 || sum < target) {
            return 0;
        }
        sum = (sum + target) / 2;
        return check(n - 1, nums, sum);
    }
}

class TargetSum3 {
    public int check(int idx, int nums[], int target) {
        if(target<0){
            return 0;
        }
        if (idx == 0) {
            if (target == 0 && nums[0] == 0) {
                return 2;
            }
            if (nums[0] == target || target == 0) {
                return 1;
            }
            return 0;
        }
        int left = check(idx - 1, nums, target - nums[idx]);
        int right = check(idx - 1, nums, target);
        return left + right;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (((sum - target) % 2) == 1 || sum < target) {
            return 0;
        }
        sum = (sum - target) / 2;
        return check(n - 1, nums, sum);
    }
}

class TargetSumMemoization {
    public int check(int idx,int nums[],int target,int[][] ans){
        if(target<0){
            return 0;
        }
        if(idx==0){
            if(target==0&&nums[0]==0){
                return 2;
            }
            if(nums[0]==target||target==0){
                return 1;
            }
            return 0;
        }
        if(ans[idx][target]!=-1){
            return ans[idx][target];
        }
        int left=check(idx-1,nums,target-nums[idx],ans);
        int right=check(idx-1,nums,target,ans);
        return ans[idx][target]=left+right;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length,sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(((sum+target)%2)==1||sum<target){
            return 0;
        }
        sum=(sum+target)/2;
        if(sum<0){
            return 0;
        }
        int ans[][]=new int[n][sum+1];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(n-1,nums,sum,ans);
    }
}

class TargetSumDP {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length,sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(((sum-target)%2)==1||sum<target){
            return 0;
        }
        sum=(sum-target)/2;
        if(sum<0){
            return 0;
        }
        int ans[][]=new int[n][sum+1];
        if(nums[0]==0){
            ans[0][0]=2;
        }else{
            ans[0][0]=1;
        }
        if(nums[0]!=0&&nums[0]<=sum){
            ans[0][nums[0]]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=sum;j++){
                int left=0;
                if(j-nums[i]>=0){
                    left=ans[i-1][j-nums[i]];
                }
                int right=ans[i-1][j];
                ans[i][j]=left+right;
            }
        }
        return ans[n-1][sum];
    }
}