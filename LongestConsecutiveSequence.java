import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int count=1,ans=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            else if(nums[i]==nums[i+1]-1){
                count++;
                ans=Math.max(ans,count);
            }else{
                count=1;
            }
        }
        return ans;
    }
}

// Getting TLE with Arraylist but same worked with HashSet may be due to duplicates are not there in
// HashSet
class LongestConsecutiveSequenceTLE {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            li.add(nums[i]);
        }
        int ans=1;
        for(int i=0;i<nums.length;i++){
            if(!li.contains(nums[i]-1)){
                int check=nums[i],count=1;
                while(li.contains(++check)){
                    count++;
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}

// workign with hashset
class LongestConsecutiveSequenceWorking {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> li=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            li.add(nums[i]);
        }
        int ans=1;
        for(int i=0;i<nums.length;i++){
            if(!li.contains(nums[i]-1)){
                int check=nums[i],count=1;
                while(li.contains(++check)){
                    count++;
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}
// Optimized but array sorting is much better above mentioned first solution
class LongestConsecutiveSequenceOptimized {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> li=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            li.add(nums[i]);
        }
        int ans=1;
        for(int i=0;i<nums.length;i++){
            int current=nums[i],count=1;
            while(li.contains(--current)){
                count++;
                li.remove(current);
            }
            current=nums[i];
            while(li.contains(++current)){
                count++;

                li.remove(current);
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}