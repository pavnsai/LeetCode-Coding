import java.util.HashSet;
import java.util.Set;

public class FrogJumpWithKDistance {
    public int frogJump(int n,int k, int heights[]) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return Math.abs(heights[1] - heights[0]);
        }
        int left=0;int mini=Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            if(n-j-1>=0) {
                left = frogJump(n - j, k, heights) + Math.abs(heights[n - j] - heights[n - j - 1]);
                mini=Math.min(left,mini);
            }
        }
        return mini;
    }
}
