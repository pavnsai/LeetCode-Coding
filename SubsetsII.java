import java.util.*;

public class SubsetsII {
    public void check(int idx, int n, int[] nums, ArrayList<Integer> temp, List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));

        for(int i=idx;i<n;i++){
            if(i>idx&&nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            check(i+1,n,nums,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        check(0,nums.length,nums,new ArrayList<Integer>(),ans);
        return ans;
    }
}

// brute force
class SubsetsIIBruteForce {
    public void check(int idx, int n, int[] nums, ArrayList<Integer> temp, Set<List<Integer>> ans){
        if(idx==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        check(idx+1,n,nums,temp,ans);
        temp.remove(temp.size()-1);
        check(idx+1,n,nums,temp,ans);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans=new HashSet<>();
        Arrays.sort(nums);
        check(0,nums.length,nums,new ArrayList<Integer>(),ans);
        List<List<Integer>>result=new ArrayList<>();
        result.addAll(ans);
        return result;
    }
}
