import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FrogJumpTLE {
    public void jump(int n, int heights[], int ans, Set<Integer> st) {
        if (n == 1) {
            st.add(ans);
            return;
        }
        if (n == 2) {
            ans = ans + Math.abs(heights[1] - heights[0]);
            st.add(ans);
            return;
        }
        jump(n - 1, heights, ans + Math.abs(heights[n - 1] - heights[n - 2]), st);
        jump(n - 2, heights, ans + Math.abs(heights[n - 1] - heights[n - 3]), st);
        return;
    }

    public int frogJump(int n, int heights[]) {
        Set<Integer> st = new HashSet<>();
        int mini = Integer.MAX_VALUE;
        jump(n, heights, 0, st);
        for (Integer num : st) {
            mini = Math.min(mini, num);
        }
        return mini;
    }
}

// Somwhat better approach
class FrogJumpSomeWhatBetter {
    public int frogJump(int n, int heights[]) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return Math.abs(heights[1] - heights[0]);
        }
        int left = frogJump(n - 1, heights) + Math.abs(heights[n - 1] - heights[n - 2]);
        int right = frogJump(n - 2, heights) + Math.abs(heights[n - 1] - heights[n - 3]);
        return Math.min(left, right);
    }
}

// Optimized
class FrogJumpOptimized {
    public int jump(int n, int heights[], int arr[]) {
        if (n == 0 || n == 1 || n == 2) {
            return arr[n];
        }
        int left = Math.abs(heights[n - 1] - heights[n - 2]);
        int right = Math.abs(heights[n - 1] - heights[n - 3]);
        if (arr[n - 1] == -1) {
            left += jump(n - 1, heights, arr);
        } else {
            left += arr[n - 1];
        }
        if (arr[n - 2] == -1) {
            right += jump(n - 2, heights, arr);
        } else {
            right += arr[n - 2];
        }
        arr[n] = Math.min(left, right);
        return arr[n];
    }

    public int frogJump(int n, int heights[]) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return Math.abs(heights[1] - heights[0]);
        }
        int arr[] = new int[n + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = Math.abs(heights[1] - heights[0]);
        return jump(n, heights, arr);
    }
}