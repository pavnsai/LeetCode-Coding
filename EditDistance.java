import java.util.Arrays;

//TLE
 class EditDistanceTLE {
    public int check(int i,int j,String s1,String s2){
        if(j<0){
            return i+1;
        }
        if(i<0){
            return j+1;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return check(i-1,j-1,s1,s2);
        }else{
            int insert=1+check(i,j-1,s1,s2);
            int delete=1+check(i-1,j,s1,s2);
            int replace=1+check(i-1,j-1,s1,s2);
            return Math.min(insert,Math.min(delete,replace));
        }

    }

    public int minDistance(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        return check(m-1,n-1,s1,s2);
    }
}

// Memoization
class EditDistanceMemoization {
    public int check(int i,int j,String s1,String s2,int[][] ans){
        if(j<0){
            return i+1;
        }
        if(i<0){
            return j+1;
        }
        if(ans[i][j]!=-1){
            return ans[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return ans[i][j]=check(i-1,j-1,s1,s2,ans);
        }else{
            int insert=1+check(i,j-1,s1,s2,ans);
            int delete=1+check(i-1,j,s1,s2,ans);
            int replace=1+check(i-1,j-1,s1,s2,ans);
            return ans[i][j]=Math.min(insert,Math.min(delete,replace));
        }

    }

    public int minDistance(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int ans[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(m-1,n-1,s1,s2,ans);
    }

}


//DP

class EditDistanceDP {
    public int minDistance(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int ans[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            ans[i][0]=i;
        }
        for(int i=0;i<=n;i++){
            ans[0][i]=i;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    ans[i][j]=ans[i-1][j-1];
                }else{
                    int insert=1+ans[i][j-1];
                    int delete=1+ans[i-1][j];
                    int replace=1+ans[i-1][j-1];
                    ans[i][j]=Math.min(insert,Math.min(delete,replace));
                }
            }
        }
        return ans[m][n];
        // return check(m-1,n-1,s1,s2,ans);
    }

}

//DP2

class EditDistanceDP2 {
    public int minDistance(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int prev[]=new int[n+1];
        int curr[]=new int[n+1];
        for(int i=0;i<=n;i++){
            prev[i]=i;
        }
        curr[0]=1;
        for(int i=1;i<=m;i++){
            curr[0]=i;
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=prev[j-1];
                }else{
                    int insert=1+curr[j-1];
                    int delete=1+prev[j];
                    int replace=1+prev[j-1];
                    curr[j]=Math.min(insert,Math.min(delete,replace));
                }
            }
            prev=Arrays.copyOf(curr,curr.length);
        }

        return prev[n];
    }
}