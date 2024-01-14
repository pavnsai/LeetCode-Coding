import java.util.*;
public class CombinationSumII {
    public void check( int idx,int[] arr, int target, List<Integer> ds, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if(i > idx && arr[i] == arr[i-1]) continue;
            if(arr[i]>target) break;
            ds.add(arr[i]);
            check(i + 1,arr, target - arr[i], ds, ans);
            ds.remove(ds.size() - 1);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        check(0,candidates, target, new ArrayList<>(), ans);
        return ans;

    }
}

 class CombinationSumIITLE {
    public void check(int candidates[], int idx, int n, int target, ArrayList<Integer> temp, Set<List<Integer>> ans){
        if(idx==n){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(candidates[idx]<=target){
            temp.add(candidates[idx]);
            check(candidates,idx+1,n,target-candidates[idx],temp,ans);
            temp.remove(temp.size()-1);
        }
        check(candidates,idx+1,n,target,temp,ans);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> ans=new HashSet<>();
        Arrays.sort(candidates);
        check(candidates,0,candidates.length,target,new ArrayList<Integer>(),ans);
        List<List<Integer>> result=new ArrayList<>();
        result.addAll(ans);
        return result;
    }
}
