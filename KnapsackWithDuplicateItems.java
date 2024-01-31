import java.util.Arrays;

class KnapsackWithDuplicateItemsTLE {
     static int check(int idx,int val[],int wt[],int weight){
         if(idx==0){
             return val[idx]*(weight/wt[0]);
         }
         int take=0;
         if(weight>=wt[idx])
         {
             take=val[idx]+check(idx,val,wt,weight-wt[idx]);
         }
         int notTake=check(idx-1,val,wt,weight);
         return Math.max(take,notTake);
     }
     static int knapSack(int N, int W, int val[], int wt[])
     {
         // code here
         return check(N-1,val,wt,W);
     }
}

 class KnapsackWithDuplicateItemsMemoization {
     static int check(int idx,int val[],int wt[],int weight,int[][] ans){
         if(idx==0){
             return val[idx]*(weight/wt[0]);
         }
         if(ans[idx][weight]!=-1){
             return ans[idx][weight];
         }
         int take=0;
         if(weight>=wt[idx])
         {
             take=val[idx]+check(idx,val,wt,weight-wt[idx],ans);
         }
         int notTake=check(idx-1,val,wt,weight,ans);
         return ans[idx][weight]=Math.max(take,notTake);
     }
     static int knapSack(int N, int weight, int val[], int wt[])
     {
         // code here
         int ans[][]=new int[N][weight+1];
         for(int i=0;i<N;i++){
             Arrays.fill(ans[i],-1);
         }
         return check(N-1,val,wt,weight,ans);
     }

 }

class KnapsackWithDuplicateItemsDP {
    static int knapSack(int N, int weight, int val[], int wt[])
    {
        // code here
        int ans[][]=new int[N][weight+1];
        for(int i=0;i<=weight;i++){
            ans[0][i]=val[0]*(i/wt[0]);
        }
        for(int i=1;i<N;i++){
            for(int j=0;j<=weight;j++){
                int take=0;
                if(j>=wt[i])
                {
                    take=val[i]+ans[i][j-wt[i]];
                }
                int notTake=ans[i-1][j];
                ans[i][j]=Math.max(take,notTake);
            }
        }
        return ans[N-1][weight];
    }
}