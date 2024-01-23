import java.util.Arrays;

class NinjasTrainingTLE {
    public static int sum(int n,int last,int points[][]){
        if(n==0){
            int maxi=0;
            for(int i=0;i<=2;i++){
                if(i!=last){
                    maxi=Math.max(maxi,points[0][i]);
                }
            }
            return maxi;
        }
        int maxi=0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                int point=points[n][i]+sum(n-1,i,points);
                maxi=Math.max(maxi,point);
            }
        }
        return maxi;
    }
    public static int ninjaTraining(int n, int points[][]) {
        return sum(n-1,3,points);
    }
}
//Optimized Memoization

 class NinjasTraining {
     public static int sum(int n,int last,int points[][],int ans[][]){
         if(n==0){
             int maxi=0;
             for(int i=0;i<=2;i++){
                 if(i!=last){
                     maxi=Math.max(maxi,points[0][i]);
                 }
             }
             ans[0][last]=maxi;
             return maxi;
         }
         int maxi=0;
         for(int i=0;i<=2;i++){
             if(i!=last){
                 int point=points[n][i];
                 if(ans[n-1][i]==-1){
                     point+=sum(n-1,i,points,ans);
                 }
                 else{
                     point+=ans[n-1][i];
                 }
                 maxi=Math.max(maxi,point);
             }
         }
         ans[n][last]=maxi;
         return maxi;
     }
     public static int ninjaTraining(int n, int points[][]) {
         int ans[][]=new int[n][4];
         for (int i = 0; i < n; i++) {
             Arrays.fill(ans[i], -1);
         }
         return sum(n-1,3,points,ans);
     }
 }