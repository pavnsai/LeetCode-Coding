import java.util.Arrays;

class MatrixSumInAMatrixTLE {
     static int sum(int N,int r,int c,int Matrix[][]){
         if(c>=N||c<0){
             return Integer.MIN_VALUE;
         }
         if(r==N-1){
             return Matrix[r][c];
         }
         int sum1=Matrix[r][c]+sum(N,r+1,c,Matrix);
         int sum2=Matrix[r][c]+sum(N,r+1,c-1,Matrix);
         int sum3=Matrix[r][c]+sum(N,r+1,c+1,Matrix);
         return Math.max(sum1,Math.max(sum2,sum3));
     }
     static int maximumPath(int N, int Matrix[][])
     {
         // code here
         int ans=0;
         for(int i=0;i<N;i++){
             ans=Math.max(ans,sum(N,0,i,Matrix));
         }
         return ans;
     }
}

 class MatrixSumInAMatrixMemoization {
     static int sum(int N,int r,int c,int Matrix[][],int ans[][]){
         if(c>=N||c<0){
             return Integer.MIN_VALUE;
         }
         if(r==N-1){
             return Matrix[r][c];
         }
         if(ans[r][c]!=-1){
             return ans[r][c];
         }
         int sum1=Matrix[r][c]+sum(N,r+1,c,Matrix,ans);
         int sum2=Matrix[r][c]+sum(N,r+1,c-1,Matrix,ans);
         int sum3=Matrix[r][c]+sum(N,r+1,c+1,Matrix,ans);
         ans[r][c]=Math.max(sum1,Math.max(sum2,sum3));
         return ans[r][c];
     }
     static int maximumPath(int N, int Matrix[][])
     {
         // code here
         int ans=0;
         int res[][]=new int[N][N];
         for(int i=0;i<N;i++){
             Arrays.fill(res[i],-1);
         }
         for(int i=0;i<N;i++){
             ans=Math.max(ans,sum(N,0,i,Matrix,res));
         }
         return ans;
     }
 }
class MatrixSumInAMatrixDP {
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int ans=0;
        int res[][]=new int[N][N];
        for(int i=0;i<N;i++){
            res[N-1][i]=Matrix[N-1][i];
        }
        for(int i=N-2;i>=0;i--){
            for(int j=N-1;j>=0;j--){ // check where J starts from
                int sum1=Integer.MIN_VALUE,sum2=sum1,sum3=sum2;
                if(j-1>=0){
                    sum2=res[i+1][j-1];
                }
                sum1=res[i+1][j];
                if(j+1<N){
                    sum3=res[i+1][j+1];
                }
                res[i][j]=Matrix[i][j]+Math.max(sum1,Math.max(sum2,sum3));
            }
        }
        for(int i=0;i<N;i++){
            ans=Math.max(ans,res[0][i]);
        }
        return ans;
    }
}