import java.util.Arrays;

class BestTimeToBuyAndSellStockIITLE {
     public int check(int i,int buy,int[] prices){
         if(i==prices.length){
             return 0;
         }
         if(buy==1){
             return Math.max(-prices[i]+check(i+1,0,prices),check(i+1,1,prices));
         }else{
             return Math.max(prices[i]+check(i+1,1,prices),check(i+1,0,prices));
         }
     }
     public int maxProfit(int[] prices) {
         int n=prices.length;
         return check(0,1,prices);
     }
}


//Memoization
class BestTimeToBuyAndSellStockIIMemoization {
    public int check(int i,int buy,int[] prices,int[][] ans){
        if(i==prices.length){
            return 0;
        }
        if(ans[i][buy]!=-1){
            return ans[i][buy];
        }
        if(buy==1){
            return ans[i][buy]=Math.max(-prices[i]+check(i+1,0,prices,ans),check(i+1,1,prices,ans));
        }else{
            return ans[i][buy]=Math.max(prices[i]+check(i+1,1,prices,ans),check(i+1,0,prices,ans));
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int ans[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(0,1,prices,ans);
    }

}

//DP
class BestTimeToBuyAndSellStockIIDP {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int ans[][]=new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                if(j==1){
                    ans[i][j]=Math.max(-prices[i]+ans[i+1][0],ans[i+1][1]);
                }else{
                    ans[i][j]=Math.max(prices[i]+ans[i+1][1],ans[i+1][0]);
                }
            }
        }
        return ans[0][1];
    }
}

//DP2
class BestTimeToBuyAndSellStockIIDP2 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int ans[][]=new int[n+1][2];
        int curr0=0,curr1=0;
        int next0=0,next1=0;
        for(int i=n-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                if(j==1){
                    curr1=Math.max(-prices[i]+next0,next1);
                    // ans[i][j]=Math.max(-prices[i]+ans[i+1][0],ans[i+1][1]);
                }else{
                    curr0=Math.max(prices[i]+next1,next0);
                    // ans[i][j]=Math.max(prices[i]+ans[i+1][1],ans[i+1][0]);
                }
            }
            next1=curr1;
            next0=curr0;
        }
        return curr1;
        // return ans[0][1];
        // return check(0,1,prices,ans);
    }

}