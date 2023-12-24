import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySizeequalsK {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> hp=new HashMap<>();
        int sum=0,ans=0;
        hp.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem=sum-k;
            if(hp.containsKey(rem)){
                ans=Math.max(ans,i-hp.get(rem));
            }
            if(!hp.containsKey(sum)){
                hp.put(sum,i);
            }
        }
        return ans;
    }
}
