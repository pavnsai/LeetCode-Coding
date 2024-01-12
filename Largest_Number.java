import java.util.Arrays;

class SolutionLargestNumber {
    public String largestNumber(int[] nums) {
        String [] arr= new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i]+"";
        }
        Arrays.sort(arr,(a, b)-> {
            String s1 = a + "" + b;
            String s2 = b + "" + a;
            return s2.compareTo(s1);
        });
        String ans="";
        for(int i=0;i<nums.length;i++){
            ans+=arr[i];
        }
        if(ans.charAt(0)=='0'){
            return "0";
        }
        return ans;
    }
}