import java.util.Arrays;

//TLE
class CoinChangeIITLE {
    public int check(int idx,int[] coins,int target){
        if(idx==0){
            return (target%coins[0]==0)?1:0;
        }
        int left=0;
        if(coins[idx]<=target){
            left=check(idx,coins,target-coins[idx]);
        }
        int right=check(idx-1,coins,target);
        return left+right;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        return check(n-1,coins,amount);
    }
}

// Memoization

class CoinChangeIIMemoization {
    public int check(int idx,int[] coins,int target,int[][] ans){
        if(idx==0){
            return (target%coins[0]==0)?1:0;
        }
        int left=0;
        if(ans[idx][target]!=-1){
            return ans[idx][target];
        }
        if(coins[idx]<=target){
            left=check(idx,coins,target-coins[idx],ans);
        }
        int right=check(idx-1,coins,target,ans);
        return ans[idx][target]=left+right;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int ans[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(n-1,coins,amount,ans);
    }
}

//Dp

class CoinChangeIIDP {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int ans[][]=new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                ans[0][i]=1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int take=0;
                if(j-coins[i]>=0){
                    take=ans[i][j-coins[i]];
                }
                int notTake=ans[i-1][j];
                ans[i][j]=take+notTake;
            }
        }
        return ans[n-1][amount];
    }
}