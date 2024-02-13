import java.util.Arrays;

//TLE
class BestTimeToBuyAndSellStockWithTransactionFeeTLE {
    public int check(int i,int buy,int fee,int prices[]){
        if(i==prices.length){
            return 0;
        }
        if(buy==1){
            return Math.max(-prices[i]+check(i+1,0,fee,prices),check(i+1,1,fee,prices));
        }else{
            return Math.max(-fee+prices[i]+check(i+1,1,fee,prices),check(i+1,0,fee,prices));
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        return check(0,1,fee,prices);
    }
}

//Memoization
class BestTimeToBuyAndSellStockWithTransactionFeeMemoization {
    public int check(int i,int buy,int fee,int prices[],int ans[][]){
        if(i==prices.length){
            return 0;
        }
        if(ans[i][buy]!=-1){
            return ans[i][buy];
        }
        if(buy==1){
            return ans[i][buy]=Math.max(-prices[i]+check(i+1,0,fee,prices,ans),check(i+1,1,fee,prices,ans));
        }else{
            return ans[i][buy]=Math.max(-fee+prices[i]+check(i+1,1,fee,prices,ans),check(i+1,0,fee,prices,ans));
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int ans[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(0,1,fee,prices,ans);
    }
}
//DP
class BestTimeToBuyAndSellStockWithTransactionFeeDP {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int ans[][]=new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            for(int buy=1;buy>=0;buy--){
                if(buy==1){
                    ans[i][buy]=Math.max(-prices[i]+ans[i+1][0],ans[i+1][1]);
                }else{
                    ans[i][buy]=Math.max(-fee+prices[i]+ans[i+1][1],ans[i+1][0]);
                }
            }
        }
        return ans[0][1];
    }
}