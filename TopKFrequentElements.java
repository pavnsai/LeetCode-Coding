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

//using list and sorting

class Solutionlist {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.merge(i, 1, Integer::sum);//For Getting Frequency
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a)); //Sort by Frequency in descending order
        int res[] = new int[k];
        for (int i = 0; i < k; ++i)
            res[i] = list.get(i);
        return res;
    }
}

// Bucket SOrt Efficicent
class SolutionBKTSort {
    public int[] topKFrequent(int[] nums, int k) {
        // Get the length of the input array
        int n = nums.length;

        // Create an array of lists to store elements based on their frequency
        List<Integer> ff[] = new List[n+1];

        // Initialize each list in the array
        for(int i=0; i<=n; i++){
            ff[i] = new ArrayList<>();
        }

        // Create an array to store the final top K frequent elements
        int ans[] = new int[k];

        // Create a hash map to store frequencies of elements
        HashMap<Integer,Integer> map = new HashMap<>();

        // Calculate frequencies and store them in the hash map
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Populate the frequency array ff with elements based on their frequency
        for(int key: map.keySet()){
            int val = map.get(key);
            ff[val].add(key);
        }

        // Index to track the position in the ans array
        int idx = 0;

        // Traverse through the frequency array in reverse order and fill ans
        for(int i=n; i>=0 && idx<k; i--){
            // Check if the current frequency list is not empty
            if(!ff[i].isEmpty()){
                // Iterate through the elements with the current frequency
                for(int e: ff[i]){
                    ans[idx++] = e; // Add the element to the ans array
                    if(idx >= k){
                        break; // Stop if we have filled up the ans array
                    }
                }
            }
        }

        return ans; // Return the final array containing top K frequent elements
    }
}