public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int index=1;
        for(int i=index;i<nums.length;i++){
            for(int j=0;j+i<nums.length;j++){
                if(nums[j]+nums[j+i]==target){
                    return new int [] {j,j+i};
                }
            }
        }
        return new int [0];
    }
}
