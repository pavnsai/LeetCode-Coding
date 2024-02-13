import java.util.Arrays;

//TLE
 class BestTimeToBuyAndSellStockIVTLE {
    public int check(int i, int buy,int count,int k,int prices[]){
        if(count==k||i==prices.length){
            return 0;
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+check(i+1,0,count,k,prices),check(i+1,1,count,k,prices));
        }else{
            profit=Math.max(prices[i]+check(i+1,1,count+1,k,prices),check(i+1,0,count,k,prices));
        }
        return profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        return check(0,1,0,k,prices);
    }
}
//Memoization
class BestTimeToBuyAndSellStockIVMemoization {
    public int check(int i, int buy,int count,int k,int prices[],int ans[][][]){
        if(count==k||i==prices.length){
            return 0;
        }
        if(ans[i][buy][count]!=-1){
            return ans[i][buy][count];
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+check(i+1,0,count,k,prices,ans),check(i+1,1,count,k,prices,ans));
        }else{
            profit=Math.max(prices[i]+check(i+1,1,count+1,k,prices,ans),check(i+1,0,count,k,prices,ans));
        }
        return ans[i][buy][count]=profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int ans[][][]=new int[n][2][k];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i][0],-1);
            Arrays.fill(ans[i][1],-1);
        }
        return check(0,1,0,k,prices,ans);
    }
}

//DP
class BestTimeToBuyAndSellStockIVDP {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int ans[][][]=new int[n+1][2][k+1];
        for(int i=n-1;i>=0;i--){
            for(int buy=1;buy>=0;buy--){
                for(int count=k-1;count>=0;count--){
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
        // return check(0,1,0,k,prices,ans);
    }

}

//DP2
class BestTimeToBuyAndSellStockIVDP2 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int ans[][][] = new int[n + 1][2][k + 1];
        int forw[][] = new int[2][k + 1];
        int curr[][] = new int[2][k + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                for (int count = k - 1; count >= 0; count--) {
                    int profit = 0;
                    if (buy == 1) {
                        profit = Math.max(-prices[i] + forw[0][count], forw[1][count]);
                    } else {
                        profit = Math.max(prices[i] + forw[1][count + 1], forw[0][count]);
                    }
                    curr[buy][count] = profit;
                }
                forw = Arrays.copyOf(curr, curr.length);
            }
        }
        return forw[1][0];
    }
}

//Memoization2
class BestTimeToBuyAndSellStockIVMemoization2 {
    public int check(int i, int trans,int k,int prices[],int ans[][]){
        if(trans==2*k||i==prices.length){
            return 0;
        }
        if(ans[i][trans]!=-1){
            return ans[i][trans];
        }
        int profit=0;
        if(trans%2==0){
            profit=Math.max(-prices[i]+check(i+1,trans+1,k,prices,ans),check(i+1,trans,k,prices,ans));
        }else{
            profit=Math.max(prices[i]+check(i+1,trans+1,k,prices,ans),check(i+1,trans,k,prices,ans));
        }
        return ans[i][trans]=profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int ans[][]=new int[n][2*k];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(0,0,k,prices,ans);
    }
}

//DP3
class BestTimeToBuyAndSellStockIVDP3 {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int ans[][]=new int[n+1][2*k+1];
        for(int i=n-1;i>=0;i--){
            for(int trans=2*k-1;trans>=0;trans--){
                int profit=0;
                if(trans%2==0){
                    profit=Math.max(-prices[i]+ans[i+1][trans+1],ans[i+1][trans]);
                }else{
                    profit=Math.max(prices[i]+ans[i+1][trans+1],ans[i+1][trans]);
                }
                ans[i][trans]=profit;
            }
        }
        return ans[0][0];
    }
}

//DP4
class BestTimeToBuyAndSellStockIVDP4 {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int curr[]=new int[2*k+1];
        int forw[]=new int[2*k+1];
        for(int i=n-1;i>=0;i--){
            for(int trans=2*k-1;trans>=0;trans--){
                int profit=0;
                if(trans%2==0){
                    profit=Math.max(-prices[i]+forw[trans+1],forw[trans]);
                }else{
                    profit=Math.max(prices[i]+forw[trans+1],forw[trans]);
                }
                curr[trans]=profit;
            }
            forw=Arrays.copyOf(curr,curr.length);
        }
        return forw[0];
    }

}