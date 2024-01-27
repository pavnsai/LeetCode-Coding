import java.util.ArrayList;
import java.util.Arrays;

class SubsetSumProblemTLE {
    static Boolean sum(int idx,int N,int arr[],int sum,int currentSum){
        if(currentSum==sum){
            return true;
        }
        if(currentSum>sum){
            return false;
        }
        if(idx==N){
            if(sum==currentSum){
                return true;
            }
            return false;
        }
        Boolean chk1=sum(idx+1,N,arr,sum,currentSum+arr[idx]);
        Boolean chk2=sum(idx+1,N,arr,sum,currentSum);
        return chk1||chk2;

    }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        return sum(0,N,arr,sum,0);
    }
}

 class SubsetSumProblemTLE2 {
     static boolean check(int idx,int N,int arr[],int sum,ArrayList<Integer> temp){
         if(sum==0){
             return true;
         }
         if(sum<0){
             return false;
         }
         if(idx==N){
             if(sum==0){
                 return true;
             }
             return false;
         }
         if(check(idx+1,N,arr,sum-arr[idx],temp))
             return true;
         if(check(idx+1,N,arr,sum,temp))
             return true;
         return false;
     }
     static Boolean isSubsetSum(int N, int arr[], int sum){
         // code here
         return check(0,N,arr,sum,new ArrayList<Integer>());
     }
 }

class SubsetSumProblemMemoization {
    static Boolean sum(int idx,int N,int arr[],int sum,int currentSum,Boolean ans[][]){
        if(currentSum==sum){
            return true;
        }
        if(currentSum>sum){
            return false;
        }
        if(idx==N){
            if(sum==currentSum){
                return true;
            }
            return false;
        }
        if(ans[idx][currentSum] != null){
            return ans[idx][currentSum];
        }
        Boolean chk1=sum(idx+1,N,arr,sum,currentSum+arr[idx],ans);
        Boolean chk2=sum(idx+1,N,arr,sum,currentSum,ans);
        ans[idx][currentSum]=chk1||chk2;
        return ans[idx][currentSum];

    }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        Boolean ans[][]=new Boolean[N][sum+1];
        for(int i=0;i<N;i++){
            Arrays.fill(ans[i],null);
        }
        return sum(0,N,arr,sum,0,ans);
    }
}

class SubsetSumProblemDP {

    static Boolean sum(int idx, int arr[], int currentSum, Boolean ans[][]) {
        if (currentSum == 0) {
            return true;
        }
        if (currentSum < 0) {
            return false;
        }
        if (idx < 0) {
            return (currentSum == 0);
        }
        if (ans[idx][currentSum] != null) {
            return ans[idx][currentSum];
        }
        Boolean chk1 = sum(idx - 1, arr, currentSum - arr[idx], ans);
        Boolean chk2 = sum(idx - 1, arr, currentSum, ans);
        return ans[idx][currentSum] = chk1 || chk2;
        // return ans[idx][currentSum];
    }

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        // code here
        boolean ans[][] = new boolean[N][sum + 1];
        // for(int i=0;i<N;i++){
        //     Arrays.fill(ans[i],null);
        // }
        for (int i = 0; i < N; i++) {
            ans[i][0] = true;
        }
        if (arr[0] <= sum)
            ans[0][arr[0]] = true;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean chk1 = false;
                if (j - arr[i] >= 0) {
                    chk1 = ans[i - 1][j - arr[i]];
                }
                boolean chk2 = ans[i - 1][j];
                ans[i][j] = chk1 || chk2;
            }
        }
        return ans[N - 1][sum];
        // return sum(N-1,arr,sum,ans);
    }
}