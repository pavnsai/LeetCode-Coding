import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public void check(int n, int[] nums, ArrayList<Integer> temp, List<List<Integer>> ans){
        if(temp.size()==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            check(n,nums,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        check(nums.length,nums,new ArrayList<Integer>(),ans);
        return ans;
    }
}
//Optimized
class PermutationsOptimized {
    public void swap(int a,int b,int nums[]){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
        return;
    }
    public void check(int idx,int n,int[] nums, List<List<Integer>> ans){
        if(idx==n){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(nums[i]);
            }
            ans.add(temp);
            return;
        }
        for(int i=idx;i<n;i++){
            swap(i,idx,nums);
            check(idx+1,n,nums,ans);
            swap(i,idx,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        check(0,nums.length,nums,ans);
        return ans;
    }
}
