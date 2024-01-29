import java.util.Arrays;

//TLE
class PartitionsWithGivenDifferenceTLE {
    static int mod=(int)Math.pow(10,9)+7;
    public static int check(int idx,int sum,int arr[]){
        if(sum<0){
            return 0;
        }
        if(idx==0){
            if(arr[0]==0&&sum==0){
                return 2;
            }
            if(arr[0]==sum||sum==0){
                return 1;
            }
            return 0;
            // return (arr[0]==sum)?1:0;
        }
        int left=check(idx-1,sum-arr[idx],arr)%mod;
        int right=check(idx-1,sum,arr)%mod;
        return (left+right)%mod;
    }
    public static int countPartitions(int n, int d, int[] arr) {
        // Write your code here.
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        if(((sum-d)%2==1)||sum<d){
            return 0;
        }
        sum=(sum-d)/2;
        return check(n-1,sum,arr);
    }
}

class PartitionsWithGivenDifferenceMemoization{
    static int mod=(int)Math.pow(10,9)+7;
    public static int check(int idx,int sum,int arr[],int[][] ans){
        if(sum<0){
            return 0;
        }
        if(idx==0){
            if(arr[0]==0&&sum==0){
                return 2;
            }
            if(arr[0]==sum||sum==0){
                return 1;
            }
            return 0;
            // return (arr[0]==sum)?1:0;
        }
        if(ans[idx][sum]!=-1){
            return ans[idx][sum];
        }
        int left=check(idx-1,sum-arr[idx],arr,ans)%mod;
        int right=check(idx-1,sum,arr,ans)%mod;
        return ans[idx][sum]=(left+right)%mod;
    }
    public static int countPartitions(int n, int d, int[] arr) {
        // Write your code here.
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        if(((sum-d)%2==1)||sum<d){
            return 0;
        }
        sum=(sum-d)/2;
        int ans[][]=new int[n][sum+1];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(n-1,sum,arr,ans);
    }
}

class PartitionsWithGivenDifferenceDP{
    static int mod=(int)Math.pow(10,9)+7;
    public static int countPartitions(int n, int d, int[] arr) {
        // Write your code here.
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        if(((sum-d)%2==1)||sum<d){
            return 0;
        }
        sum=(sum-d)/2;
        int ans[][]=new int[n][sum+1];
        if(arr[0]==0){
            ans[0][0]=2;
        }else{
            ans[0][0]=1;
        }
        if(arr[0]!=0&&arr[0]<=sum){
            ans[0][arr[0]]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=sum;j++){
                int left=0;
                if(j-arr[i]>=0){
                    left=ans[i-1][j-arr[i]];
                }
                int right=ans[i-1][j];
                ans[i][j]=((left%mod)+(right%mod))%mod;
            }
        }
        return ans[n-1][sum];
    }
}