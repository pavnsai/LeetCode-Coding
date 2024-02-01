import java.util.Arrays;

//TLE
class CoinChangeTLE {
    public int check(int idx,int[] coins,int amount){
        if(idx==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            return Integer.MAX_VALUE;
        }
        int take=Integer.MAX_VALUE;
        if(amount>=coins[idx]){
            take=check(idx,coins,amount-coins[idx]);
        }
        if(take!=Integer.MAX_VALUE){
            take=take+1;
        }
        int notTake=check(idx-1,coins,amount);
        return Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int ans=check(n-1,coins,amount);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}
//Memoization
class CoinChangeMemoization {
    public int check(int idx,int[] coins,int amount,int[][] ans){
        if(idx==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            return Integer.MAX_VALUE;
        }
        if(ans[idx][amount]!=-1){
            return ans[idx][amount];
        }
        int take=Integer.MAX_VALUE;
        if(amount>=coins[idx]){
            take=check(idx,coins,amount-coins[idx],ans);
        }
        if(take!=Integer.MAX_VALUE){
            take=take+1;
        }
        int notTake=check(idx-1,coins,amount,ans);
        return ans[idx][amount]=Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=check(n-1,coins,amount,dp);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}
//DP
class CoinChangeDP {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }else{
                dp[0][i]=Integer.MAX_VALUE;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int take=Integer.MAX_VALUE;
                if(j>=coins[i]){
                    take=dp[i][j-coins[i]];
                }
                if(take!=Integer.MAX_VALUE){
                    take=take+1;
                }
                int notTake=dp[i-1][j];
                dp[i][j]=Math.min(take,notTake);
            }
        }
        return (dp[n-1][amount]!=Integer.MAX_VALUE)?dp[n-1][amount]:-1;
    }
}

//DP
class CoinChangeDPOptimized {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int curr[]=new int[amount+1];
        int prev[]=new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                prev[i]=i/coins[0];
            }else{
                prev[i]=Integer.MAX_VALUE;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int take=Integer.MAX_VALUE;
                if(j>=coins[i]){
                    take=curr[j-coins[i]];
                }
                if(take!=Integer.MAX_VALUE){
                    take=take+1;
                }
                int notTake=prev[j];
                curr[j]=Math.min(take,notTake);
            }
            prev=Arrays.copyOf(curr,curr.length);
        }
        return (prev[amount]!=Integer.MAX_VALUE)?prev[amount]:-1;
    }
}