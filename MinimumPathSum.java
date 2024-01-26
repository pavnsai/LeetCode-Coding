import java.util.Arrays;

class MinimumPathSumTLE {
    public void dfs(int a,int b,int [][]grid,int arr[],int sum){
        if(a==0&&b==0){
            arr[0]=Math.min(arr[0],sum+grid[a][b]);
            return;
        }
        if(a<0||b<0){
            return;
        }
        dfs(a-1,b,grid,arr,sum+grid[a][b]);
        dfs(a,b-1,grid,arr,sum+grid[a][b]);
        return;
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int arr[]={Integer.MAX_VALUE};
        dfs(m-1,n-1,grid,arr,0);
        return arr[0];
    }
}

 class MinimumPathSumTLE2 {
     public int dfs(int a,int b,int [][]grid){
         if(a==0&&b==0){
             return grid[a][b];
         }
         if(a<0||b<0){
             return Integer.MAX_VALUE;
         }
         int up=dfs(a-1,b,grid);
         int left=dfs(a,b-1,grid);
         return Math.min(up,left)+grid[a][b];

         // if we keep below one we might get error due to overflow
//         int up=grid[a][b]+dfs(a-1,b,grid);
//         int left=grid[a][b]+dfs(a,b-1,grid);
//         return Math.min(up,left);

         // or use below one so that in recursion tree it wont add if a<0 it will directly
         // return max value and it will pick min
//         int up=Integer.MAX_VALUE;
//         if(a>0)
//             up=grid[a][b]+dfs(a-1,b,grid);
//         int left=Integer.MAX_VALUE;
//         if(b>0)
//             left=grid[a][b]+dfs(a,b-1,grid);
     }
     public int minPathSum(int[][] grid) {
         int m=grid.length;
         int n=grid[0].length;
         return dfs(m-1,n-1,grid);
     }
 }

 class MinimumPathSumMemoization {
     public int dfs(int a,int b,int [][]grid,int[][] ans){
         if(a==0&&b==0){
             return grid[a][b];
         }
         if(a<0||b<0){
             return Integer.MAX_VALUE;
         }
         if(ans[a][b]!=-1){
             return ans[a][b];
         }
         int up=dfs(a-1,b,grid,ans);
         int left=dfs(a,b-1,grid,ans);
         ans[a][b]=Math.min(up,left)+grid[a][b];
         return ans[a][b];
     }
     public int minPathSum(int[][] grid) {
         int m=grid.length;
         int n=grid[0].length;
         int arr[]={Integer.MAX_VALUE};
         int ans[][]=new int[m][n];
         for(int i=0;i<m;i++){
             Arrays.fill(ans[i],-1);
         }
         return dfs(m-1,n-1,grid,ans);
     }

 }

class MinimumPathSumDP {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans[][] = new int[m][n];
        int temp = 0;
        for (int i = 0; i < m; i++) {
            temp += grid[i][0];
            ans[i][0] = temp;
        }
        temp = 0;
        for (int i = 0; i < n; i++) {
            temp += grid[0][i];
            ans[0][i] = temp;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = grid[i][j] + Math.min(ans[i - 1][j], ans[i][j - 1]);
            }
        }
        return ans[m - 1][n - 1];
    }
}