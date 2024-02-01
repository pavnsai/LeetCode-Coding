import java.util.Arrays;

//TLE
class KnapsackProblem01TLE {
    static int check(int idx,int W,int wt[],int val[]){
        if(idx==0){
            if(wt[0]<=W){
                return val[idx];
            }
            return 0;
        }
        int take=Integer.MIN_VALUE;
        if(wt[idx]<=W){
            take=val[idx]+check(idx-1,W-wt[idx],wt,val);
        }
        int notTake=check(idx-1,W,wt,val);
        return Math.max(take,notTake);
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        return check(n-1,W,wt,val);
    }
}

//Memoization
class KnapsackProblem01Memoization {
    static int check(int idx,int W,int wt[],int val[],int[][] ans){
        if(idx==0){
            if(wt[0]<=W){
                return val[idx];
            }
            return 0;
        }
        if(ans[idx][W]!=-1){
            return ans[idx][W];
        }
        int take=Integer.MIN_VALUE;
        if(wt[idx]<=W){
            take=val[idx]+check(idx-1,W-wt[idx],wt,val,ans);
        }
        int notTake=check(idx-1,W,wt,val,ans);
        return ans[idx][W]=Math.max(take,notTake);
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        int ans[][]=new int[n][W+1];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(n-1,W,wt,val,ans);
    }
}

class KnapsackProblem01DP {
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        int ans[][]=new int[n][W+1];
        for(int j=wt[0];j<=W;j++){
            ans[0][j]=val[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=W;j++){
                int take=Integer.MIN_VALUE;
                if(wt[i]<=j){
                    take=val[i]+ans[i-1][j-wt[i]];
                }
                int notTake=ans[i-1][j];
                ans[i][j]=Math.max(take,notTake);
            }
        }
        return ans[n-1][W];
    }
}

class KnapsackProblem01DPOptimized {
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        int prev[]=new int[W+1];
        int curr[]=new int[W+1];
        for(int j=wt[0];j<=W;j++){
            prev[j]=val[0];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=W;j++){
                int take=Integer.MIN_VALUE;
                if(wt[i]<=j){
                    take=val[i]+prev[j-wt[i]];
                }
                int notTake=prev[j];
                curr[j]=Math.max(take,notTake);
            }
            prev = Arrays.copyOf(curr, curr.length);
        }
        return prev[W];
    }
}