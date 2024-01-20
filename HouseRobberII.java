public class HouseRobberII {
    public int rob(int[] nums) {
        int ans[] = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        int prev1 = nums[0], prev2 = Math.max(nums[0], nums[1]), curr = 0;
        for (int i = 2; i < nums.length - 1; i++) {
            int pick = nums[i] + prev1;
            int notPick = prev2;
            curr = Math.max(pick, notPick);
            prev1 = prev2;
            prev2 = curr;
        }
        prev1 = nums[1];
        prev2 = Math.max(nums[1], nums[2]);
        int curr2 = 0;
        for (int i = 3; i < nums.length; i++) {
            int pick = nums[i] + prev1;
            int notPick = prev2;
            curr2 = Math.max(pick, notPick);
            prev1 = prev2;
            prev2 = curr2;
        }
        return Math.max(curr, curr2);

    }
}
