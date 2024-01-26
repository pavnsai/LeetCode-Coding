import java.util.Arrays;

class UniquePathsIITLE {
    public int dfs(int a,int b,int[][] obstacleGrid){
        if(a==0&&b==0&&obstacleGrid[a][b]==0){
            return 1;
        }
        if(a<0||b<0||obstacleGrid[a][b]==1){
            return 0;
        }
        int up=dfs(a-1,b,obstacleGrid);
        int left=dfs(a,b-1,obstacleGrid);
        return up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return dfs(obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid);
    }
}
public class UniquePathsII {
    public int dfs(int a, int b, int[][] obstacleGrid, int[][] ans) {
        if (a == 0 && b == 0 && obstacleGrid[a][b] == 0) {
            return 1;
        }
        if (a < 0 || b < 0 || obstacleGrid[a][b] == 1) {
            return 0;
        }
        if (ans[a][b] != -1) {
            return ans[a][b];
        }
        int up = dfs(a - 1, b, obstacleGrid, ans);
        int left = dfs(a, b - 1, obstacleGrid, ans);
        ans[a][b] = up + left;
        return ans[a][b];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int ans[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], -1);
        }
        return dfs(m - 1, n - 1, obstacleGrid, ans);
    }
}


class UniquePathsIIDP {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int ans[][] = new int[m][n];
        boolean check = false;
        for (int i = 0; i < m; i++) {
            if (check) {
                ans[i][0] = 0;
                continue;
            }
            if (obstacleGrid[i][0] == 1) {
                check = true;
                ans[i][0] = 0;
            } else {
                ans[i][0] = 1;
            }
        }
        check = false;
        for (int i = 0; i < n; i++) {
            if (check) {
                ans[0][i] = 0;
                continue;
            }
            if (obstacleGrid[0][i] == 1) {
                check = true;
                ans[0][i] = 0;
            } else {
                ans[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
                } else {
                    ans[i][j] = 0;
                }
            }
        }
        return ans[m - 1][n - 1];
    }
}