import java.util.Arrays;
//check this it chefcked for element 0 also so waited till it checks all indexes
public class CountSubsetsWithSumK {
    static int mod=(int)Math.pow(10,9)+7;
    public static int check(int idx,int num[],int sum,int[][] ans){
        if(sum<0){
            return 0;
        }
        if(idx==0){
            if(sum==0&&num[0]==0){
                return 2;
            }
            if(sum==0||num[0]==sum){
                return 1;
            }
            return 0;
        }
        if(ans[idx][sum]!=-1){
            return ans[idx][sum]%mod;
        }
        int left=check(idx-1,num,sum-num[idx],ans);
        int right=check(idx-1,num,sum,ans);
        return ans[idx][sum]=((left%mod)+(right%mod))%mod;
    }
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int n=num.length;
        int ans[][]=new int[n][tar+1];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(n-1,num,tar,ans);
    }
}

class CountSubsetsWithSumKDP {
    static int mod=(int)Math.pow(10,9)+7;
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int n=num.length;
        int ans[][]=new int[n][tar+1];
        if(num[0]==0){
            ans[0][0]=2;
        }else{
            ans[0][0]=1;
        }
        if(num[0]!=0&&num[0]<=tar){
            ans[0][num[0]]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=tar;j++){
                int left=0;
                if(j-num[i]>=0){
                    left=ans[i-1][j-num[i]];
                }
                int right=ans[i-1][j];
                ans[i][j]=(left+right)%mod;
            }
        }
        return ans[n-1][tar];
    }
}