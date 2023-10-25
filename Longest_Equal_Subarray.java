import java.util.HashMap;
import java.util.List;

class Solution9 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int maxi=Integer.MIN_VALUE,i=0,start=0,n=nums.size(),maxIndex=-1,ans=-1;
        while(i<n){
            int num=nums.get(i);
            int val=1;
            if(hm.containsKey(num)){
                val=hm.get(num)+1;
                // System.out.println(val);
                hm.put(num,val);
            }else{
                // System.out.println("else "+num+" : "+val);
                hm.put(num,val);
            }
            if(maxi<=val){
                maxi=val;
                // temp_maxi=maxi;
                maxIndex=i;
            }else{
                maxi=maxi;
            }
            ans=Math.max(ans,val);
            // maxi=Math.max(maxi,val);
            if(i-start+1-maxi<=k){
                // System.out.println("coming");
                i++;
            }else{
                val=hm.get(nums.get(start))-1;
                hm.put(nums.get(start),val);
                val=hm.get(nums.get(i))-1;
                hm.put(nums.get(i),val);
                if(maxIndex==start){
                    maxi--;
                }
                start++;
            }
        }
        return ans;
    }
}



//Second Approach


class Solution10 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int maxFreq = 0;

        int i = 0, j = 0, len = nums.size();
        int[] count = new int[ len +1 ];
        while (j < len) {
            int currElem = nums.get(j);
            count[currElem]++;
            maxFreq = Math.max(maxFreq, count[currElem]);
            if (j - i + 1 - maxFreq > k) {
                count[nums.get(i)]--;
                i++;
            }
            j++;
        }

        return maxFreq;
    }
}