public class MinimumNumberK995 {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length, ans = 0, tempCount = 0;
        int flipped[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                if (flipped[i - k] == 1) {
                    tempCount--;
                }
            }
            if (tempCount % 2 == 0) {
                if (nums[i] == 0) {
                    if (i + k > n) {
                        return -1;
                    }
                    ans++;
                    tempCount++;
                    flipped[i] = 1;
                }
            } else {
                if (nums[i] == 1) {
                    if (i + k > n) {
                        return -1;
                    }
                    ans++;
                    tempCount++;
                    flipped[i] = 1;
                }
            }
        }
        return ans;
    }
}
