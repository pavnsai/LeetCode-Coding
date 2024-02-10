import java.util.Arrays;

//TLE
 class DistinctSubsequencesTLE {
    public int check(int i,int j,String s1,String s2){
        if(j<0){
            return 1;
        }
        if(i<0){
            return (j==-1)?1:0;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return check(i-1,j-1,s1,s2)+check(i-1,j,s1,s2);
        }else{
            return check(i-1,j,s1,s2);
        }
    }
    public int numDistinct(String s, String t) {
        int m=s.length(),n=t.length();
        return check(m-1,n-1,s,t);
    }
}

// Memoization
class DistinctSubsequencesMemoization {
    public int check(int i,int j,String s1,String s2,int ans[][]){
        if(j<0){
            return 1;
        }
        if(i<0){
            return (j==-1)?1:0;
        }
        if(ans[i][j]!=-1){
            return ans[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return ans[i][j]=check(i-1,j-1,s1,s2,ans)+check(i-1,j,s1,s2,ans);
        }else{
            return ans[i][j]=check(i-1,j,s1,s2,ans);
        }
    }
    public int numDistinct(String s, String t) {
        int m=s.length(),n=t.length();
        int ans[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(m-1,n-1,s,t,ans);
    }

}

//DP
class DistinctSubsequencesDP {
    public int numDistinct(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int ans[][]=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            ans[i][0]=1;
        }
        for(int i=0;i<n;i++){
            ans[0][i]=0;
        }
        ans[0][0]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    ans[i][j]=ans[i-1][j-1]+ans[i-1][j];
                }else{
                    ans[i][j]=ans[i-1][j];
                }
            }
        }
        return ans[m][n];
    }
}