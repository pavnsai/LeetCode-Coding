public class FindMinRotatedSortedArray {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(nums[0]<=nums[n-1]){
            return nums[0];
        }
        int a=0,b=n,ans=0;
        while(a<b){
            int mid=a+(b-a)/2;
            if(mid+1<n&&nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(mid-1>=0&&nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            if(nums[a]<nums[mid]){
                ans=nums[a];
                a=mid+1;
            }else{
                ans=nums[mid];
                b=mid-1;
            }
        }
        return ans;
    }
}
