import java.util.Arrays;

//TLE
 class BestTimeToBuyAndSellStockWithCoolDownTLE {
    public int check(int i,int buy,int prices[]){
        if(i>=prices.length){
            return 0;
        }
        if(buy==1){
            return Math.max(-prices[i]+check(i+1,0,prices),check(i+1,1,prices));
        }
        return Math.max(prices[i]+check(i+2,1,prices),check(i+1,0,prices));
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        return check(0,1,prices);
    }
}

//Memoization
class BestTimeToBuyAndSellStockWithCoolDownMemoization {
    public int check(int i,int buy,int prices[],int ans[][]){
        if(i>=prices.length){
            return 0;
        }
        if(ans[i][buy]!=-1){
            return ans[i][buy];
        }
        if(buy==1){
            return ans[i][buy]=Math.max(-prices[i]+check(i+1,0,prices,ans),check(i+1,1,prices,ans));
        }
        return ans[i][buy]=Math.max(prices[i]+check(i+2,1,prices,ans),check(i+1,0,prices,ans));
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
class BestTimeToBuyAndSellStockWithCoolDownDP {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int ans[][]=new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            for(int buy=1;buy>=0;buy--){
                if(buy==1){
                    ans[i][buy]=Math.max(-prices[i]+ans[i+1][0],ans[i+1][1]);
                }else{
                    int temp=0;
                    if(i+2<=n){
                        temp=ans[i+2][1];
                    }
                    ans[i][buy]=Math.max(prices[i]+temp,ans[i+1][0]);
                }
            }
        }
        return ans[0][1];
        // return check(0,1,prices,ans);
    }
}