import java.util.Arrays;

//TLE
class BestTimeToBuyAndSellStockIIITLE {
    public int check(int i, int buy,int count,int prices[]){
        if(count==2||i==prices.length){
            return 0;
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+check(i+1,0,count,prices),check(i+1,1,count,prices));
        }else{
            profit=Math.max(prices[i]+check(i+1,1,count+1,prices),check(i+1,0,count,prices));
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        return check(0,1,0,prices);
    }
}
//Memoization
class BestTimeToBuyAndSellStockIIIMemoization {
    public int check(int i, int buy,int count,int prices[],int ans[][][]){
        if(count==2||i==prices.length){
            return 0;
        }
        int profit=0;
        if(ans[i][buy][count]!=-1){
            return ans[i][buy][count];
        }
        if(buy==1){
            profit=Math.max(-prices[i]+check(i+1,0,count,prices,ans),check(i+1,1,count,prices,ans));
        }else{
            profit=Math.max(prices[i]+check(i+1,1,count+1,prices,ans),check(i+1,0,count,prices,ans));
        }
        return ans[i][buy][count]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int ans[][][]=new int[n][2][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i][0], -1);
            Arrays.fill(ans[i][1], -1);
        }
        return check(0,1,0,prices,ans);
    }
}
//DP
class BestTimeToBuyAndSellStockIIIDP {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int ans[][][]=new int[n+1][2][3];
        for(int i=n-1;i>=0;i--){
            for(int buy=1;buy>=0;buy--){
                for(int count=1;count>=0;count--){
                    int profit=0;
                    if(buy==1){
                        profit=Math.max(-prices[i]+ans[i+1][0][count],ans[i+1][1][count]);
                    }else{
                        profit=Math.max(prices[i]+ans[i+1][1][count+1],ans[i+1][0][count]);
                    }
                    ans[i][buy][count]=profit;
                }
            }
        }
        return ans[0][1][0];
    }

}

//DP2
class BestTimeToBuyAndSellStockIIIDP2 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int ans[][][]=new int[n+1][2][3];
        int forw[][]=new int[2][3];
        int curr[][]=new int[2][3];
        for(int i=n-1;i>=0;i--){
            for(int buy=1;buy>=0;buy--){
                for(int count=1;count>=0;count--){
                    int profit=0;
                    if(buy==1){
                        profit=Math.max(-prices[i]+forw[0][count],forw[1][count]);
                    }else{
                        profit=Math.max(prices[i]+forw[1][count+1],forw[0][count]);
                    }
                    curr[buy][count]=profit;
                }
                curr=Arrays.copyOf(forw,forw.length);
            }
        }
        return curr[1][0];
        // return ans[0][1][0];
        // return check(0,1,0,prices,ans);
    }
}
