public class HouseRobber {
    public int rob(int[] nums) {
        int ans[]=new int[nums.length];
        ans[0]=nums[0];
        if(nums.length>1){
            ans[1]=Math.max(nums[0],nums[1]);
        }
        for(int i=2;i<nums.length;i++){
            int pick=nums[i]+ans[i-2];
            int notPick=ans[i-1];
            ans[i]=Math.max(pick,notPick);
        }
        return ans[nums.length-1];
    }
}
// No Space as there are two variables
// and if there is case that first and last elements considered neighbors. in other words first and last cant be robbed
// so take max(leaving first element, leaving last element)
class HouseRobberNoSpace {
    public int rob(int[] nums) {
        int ans[]=new int[nums.length];
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int prev1=nums[0],prev2=Math.max(nums[0],nums[1]),curr=0;
        for(int i=2;i<nums.length;i++){
            int pick=nums[i]+prev1;
            int notPick=prev2;
            curr=Math.max(pick,notPick);
            prev1=prev2;
            prev2=curr;
        }
        return curr;
    }
}