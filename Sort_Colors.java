class Solution {
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        int a=0,b=0,c=n-1;
        while(b<=c){
            if(nums[b]==0){
                swap(nums,a,b);
                a++;
                b++;
            }
            else if(nums[b]==2){
                swap(nums,b,c);
                // b++;
                c--;
            }
            else if(nums[b]==1){
                b++;
            }
        }
    }
}