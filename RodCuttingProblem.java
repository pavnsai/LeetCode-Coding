import java.util.Arrays;

//TLE
class RodCuttingProblemTLE {
    public static int check(int idx,int price[],int target){
        if(idx==0){
            return target*price[idx];
        }
        int take=Integer.MIN_VALUE;
        if(target>=idx+1){
            take=price[idx]+check(idx,price,target-(idx+1));
        }
        int notTake=check(idx-1,price,target);
        return Math.max(take,notTake);
    }
    public static int cutRod(int price[], int n) {
        // Write your code here.
        return check(n-1,price,n);
    }
}

//Memoization
class RodCuttingProblemMemoization {
    public static int check(int idx,int price[],int target,int[][] ans){
        if(idx==0){
            return target*price[idx];
        }
        if(ans[idx][target]!=-1){
            return ans[idx][target];
        }
        int take=Integer.MIN_VALUE;
        if(target>=idx+1){
            take=price[idx]+check(idx,price,target-(idx+1),ans);
        }
        int notTake=check(idx-1,price,target,ans);
        return ans[idx][target]=Math.max(take,notTake);
    }
    public static int cutRod(int price[], int n) {
        // Write your code here.
        int ans[][]=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(n-1,price,n,ans);
    }
}

//DP
class RodCuttingProblemDP {
    public static int cutRod(int price[], int n) {
        // Write your code here.
        int ans[][]=new int[n][n+1];
        for(int i=0;i<=n;i++){
            ans[0][i]=i*price[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=n;j++){
                int take=Integer.MIN_VALUE;
                if(j>=i+1){
                    take=price[i]+ans[i][j-(i+1)];
                }
                int notTake=ans[i-1][j];
                ans[i][j]=Math.max(take,notTake);
            }
        }
        return ans[n-1][n];
    }
}