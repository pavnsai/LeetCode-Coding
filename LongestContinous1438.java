import java.util.PriorityQueue;
import java.util.TreeMap;

public class LongestContinous1438 {
    public int longestSubarrayTreeMap(int[] nums, int limit) {
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        int n=nums.length,j=0,i=0,maxLen=0,ans=0;
        while(j<n){
            tm.put(nums[j],tm.getOrDefault(nums[j],0)+1);
            int diff=tm.lastKey()-tm.firstKey();
            while(tm.lastKey()-tm.firstKey()>limit){
                if(tm.get(nums[i])!=1)
                    tm.put(nums[i],tm.get(nums[i])-1);
                else
                    tm.remove(nums[i]);
                i++;
            }
            maxLen=j-i+1;
            ans=Math.max(ans,maxLen);
            j++;
        }
        return ans;
    }
    public int longestSubarrayheap(int[] nums, int limit) {
        int j=0,i=0,n=nums.length,ans=0;
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a, b)->a[0]-b[0]);
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        while(j<n){
            minHeap.offer(new int[]{nums[j],j});
            maxHeap.offer(new int[]{nums[j],j});
            if(maxHeap.peek()[0]-minHeap.peek()[0]>limit){
                i=Math.min(maxHeap.peek()[1],minHeap.peek()[1])+1;
                while(maxHeap.peek()[1]<i){
                    maxHeap.poll();
                }
                while(minHeap.peek()[1]<i){
                    minHeap.poll();
                }
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
