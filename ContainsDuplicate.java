public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int j=i-1;
            int current=nums[i];
            while(j>=0&&nums[j]>current){
                nums[j+1]=nums[j];
                j--;
            }
            if(j>=0&&nums[j]==current){
                return true;
            }
            nums[j+1]=current;
        }
        return false;
    }
}


// do sorting and check neighbor elements
// store in set and check if exists
