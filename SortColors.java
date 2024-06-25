import java.util.Arrays;

public class SortColors {
    public void swap(int[] nums, int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void sortColors(int[] nums) {
//        Arrays.sort(nums);
        int l=0,r=nums.length-1,m=0;
        while(m<=r){
            if(nums[m]==0){
                swap(nums,m,l);
                l++;
                m++;
            }else if(nums[m]==2){
                swap(nums,m,r);
                r--;
            }else{
                m++;
            }
        }
    }
}
