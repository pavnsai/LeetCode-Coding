import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(mp.values());
        Collections.sort(list, Collections.reverseOrder());
        ArrayList<Integer> list2 = new ArrayList<>(list.subList(0, k));
        int[] ans = new int[list2.size()];
        int j=0;
        for (var entry : mp.entrySet()){
            if (list2.contains(entry.getValue())){
                ans[j++] = entry.getKey();
            }
        }

        return ans;
    }
}

// Using Priority queue
class SolutionPriorityQueue {
    public int[] topKFrequent(int[] nums, int k) {

        // Creating a Frequency Table
        Map<Integer,Integer> map = new HashMap();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0) + 1);
        }
        // Putting values in priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        // putting the top k values in array
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = pq.poll();
        }
        return res;
    }
}