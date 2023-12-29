public class shortestUnsortedContinousSubArray {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length,mini=Integer.MAX_VALUE,maxi=Integer.MIN_VALUE;
        if(n==1)
            return 0;
        for(int i=0;i<n;i++){
            if((i==0)&&(nums[i]>nums[i+1])){
                mini=Math.min(nums[i],mini);
                maxi=Math.max(nums[i],maxi);
            }else if((i==n-1)&&(nums[i]<nums[i-1])){
                mini=Math.min(nums[i],mini);
                maxi=Math.max(nums[i],maxi);
            }else if((i!=0&&i!=n-1)&&(nums[i] > nums[i+1] || nums[i] < nums[i-1])){
                mini=Math.min(nums[i],mini);
                maxi=Math.max(nums[i],maxi);
            }
        }
        System.out.println(mini);
        int minCount=0,maxCount=0;
        for(int i=0;i<n;i++){
            if(nums[i]>mini){
                minCount=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]<maxi){
                maxCount=i;
                break;
            }
        }
        if(maxi==Integer.MIN_VALUE||mini==Integer.MAX_VALUE)
            return 0;
        return (maxCount-minCount+1)>0?maxCount-minCount+1:0;
    }

    // Second Approach
    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int start = -1, end = -2;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);

            if (nums[i] < max) {
                end = i;
            }
            if (nums[n - 1 - i] > min) {
                start = n - 1 - i;
            }
        }

        return end - start + 1;
    }
}
