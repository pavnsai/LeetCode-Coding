import java.util.Arrays;

class UniquePathsTLE {
    public void dfs(int a,int b,int m,int n,boolean visited[][],int arr[]){
        if(a==m-1&&b==n-1){
            arr[0]++;
            return;
        }
        visited[a][b]=true;
        if(a+1<m&&!visited[a+1][b]){
            dfs(a+1,b,m,n,visited,arr);
        }
        if(b+1<n&&!visited[a][b+1]){
            dfs(a,b+1,m,n,visited,arr);
        }
        visited[a][b]=false;
        return;
    }
    public int uniquePaths(int m, int n) {
        int arr[]={0};
        boolean visited[][]=new boolean[m][n];
        dfs(0,0,m,n,visited,arr);
        return arr[0];
    }
}
class UniquePathsAnotherTLE {
    public int dfs(int a,int b){
        if(a==0&&b==0){
            return 1;
        }
        if(a<0||b<0){
            return 0;
        }
        int up=dfs(a-1,b);
        int left=dfs(a,b-1);
        return up+left;
    }
    public int uniquePaths(int m, int n) {
        return dfs(m-1,n-1);
    }
}

class UniquePathsAnotherMemoization {
    public int dfs(int a,int b,int ans[][]){
        if(a==0&&b==0){
            return 1;
        }
        if(a<0||b<0){
            return 0;
        }
        int up=0,left=0;
        if(a-1>=0&&ans[a-1][b]==-1){
            up=dfs(a-1,b,ans);
        }else if(a-1>=0){
            up=ans[a-1][b];
        }else{
            up=0;
        }
        if(b-1>=0&&ans[a][b-1]==-1){
            left=dfs(a,b-1,ans);
        }else if(b-1>=0){
            left=ans[a][b-1];
        }else{
            left=0;
        }
        ans[a][b]=up+left;
        return ans[a][b];
    }
    public int uniquePaths(int m, int n) {
        int ans[][]=new int [m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(ans[i],-1);
        }
        return dfs(m-1,n-1,ans);
    }

}

class UniquePathsAnotherMemoization2 {
    public int dfs(int a, int b, int ans[][]) {
        if (a == 0 && b == 0) {
            return 1;
        }
        if (a < 0 || b < 0) {
            return 0;
        }
        if(ans[a][b]!=-1){
            return ans[a][b];
        }
        int up = dfs(a - 1, b, ans);
        int left = dfs(a, b - 1, ans);
        ans[a][b] = up + left;
        return ans[a][b];
    }

    public int uniquePaths(int m, int n) {
        int ans[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], -1);
        }
        return dfs(m - 1, n - 1, ans);
    }
}