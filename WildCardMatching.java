import java.util.Arrays;

//TLE
class WildCardMatchingTLE {
    public boolean check(int i,int j,String s1,String s2){
        if(i<0&&j<0){
            return true;
        }
        if(j<0&&i>=0){
            return false;
        }
        if(i<0){
            for(int k=0;k<=j;k++){
                if(s2.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(s1.charAt(i)==s2.charAt(j)||s2.charAt(j)=='?'){
            return check(i-1,j-1,s1,s2);
        }else if(s2.charAt(j)=='*'){
            return check(i,j-1,s1,s2)||check(i-1,j,s1,s2);
        }else{
            return false;
        }
    }
    public boolean isMatch(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        return check(m-1,n-1,s1,s2);
    }
}
//Memoization
class WildCardMatchingMemoization {
    public boolean check(int i,int j,String s1,String s2,Boolean ans[][]){
        if(i<0&&j<0){
            return true;
        }
        if(j<0&&i>=0){
            return false;
        }
        if(i<0){
            for(int k=0;k<=j;k++){
                if(s2.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(ans[i][j]!=null){
            return ans[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)||s2.charAt(j)=='?'){
            return ans[i][j]=check(i-1,j-1,s1,s2,ans);
        }else if(s2.charAt(j)=='*'){
            return ans[i][j]=check(i,j-1,s1,s2,ans)||check(i-1,j,s1,s2,ans);
        }else{
            return ans[i][j]=false;
        }
    }
    public boolean isMatch(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        Boolean ans[][]=new Boolean[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(ans[i],null);
        }
        return check(m-1,n-1,s1,s2,ans);
    }

}

//DP
class WildCardMatchingDP {
    public boolean isMatch(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        boolean ans[][]=new boolean[m+1][n+1];
        ans[0][0]=true;
        for(int i=1;i<=m;i++){
            ans[i][0]=false;
        }
        for(int i=1;i<=n;i++){
            boolean flag=true;
            for(int k=1;k<=i;k++){
                if(s2.charAt(k-1)!='*'){
                    flag=false;
                    break;
                }
            }
            ans[0][i]=flag;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)||s2.charAt(j-1)=='?'){
                    ans[i][j]=ans[i-1][j-1];
                }else if(s2.charAt(j-1)=='*'){
                    ans[i][j]=ans[i][j-1]||ans[i-1][j];
                }else{
                    ans[i][j]=false;
                }
            }
        }
        return ans[m][n];
    }

}

//DP2
class WildCardMatchingDPOptimized {
    public boolean isMatch(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        boolean ans[][]=new boolean[m+1][n+1];
        boolean prev[]=new boolean[n+1];
        boolean curr[]=new boolean[n+1];
        prev[0]=true;
        for(int i=1;i<=n;i++){
            boolean flag=true;
            for(int k=1;k<=i;k++){
                if(s2.charAt(k-1)!='*'){
                    flag=false;
                    break;
                }
            }
            prev[i]=flag;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)||s2.charAt(j-1)=='?'){
                    curr[j]=prev[j-1];
                }else if(s2.charAt(j-1)=='*'){
                    curr[j]=curr[j-1]||prev[j];
                }else{
                    curr[j]=false;
                }
            }
            prev=Arrays.copyOf(curr,curr.length);
        }
        return prev[n];
    }
}