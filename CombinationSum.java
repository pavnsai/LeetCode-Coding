import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public void check(int[] candidates, int idx, int length, int target, List<List<Integer>> ans, ArrayList<Integer> temp) {
        if (idx == length) {
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if (candidates[idx] <= target) {
            temp.add(candidates[idx]);
            check(candidates, idx, length, target - candidates[idx], ans, temp);
            temp.remove(temp.size() - 1);
        }
        check(candidates, idx + 1, length, target, ans, temp);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        check(candidates, 0, candidates.length, target, ans, new ArrayList<Integer>());
        return ans;
    }
}
