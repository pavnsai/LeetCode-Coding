import java.util.Arrays;

//TLE
class MinimumInsertionsToMakeAStringPalindromeTLE {
    public int check(int i,int j,String s1,String s2){
        if(i<0||j<0){
            return 0;
        }
        int take1=0,take2=0,take3=0;
        if(s1.charAt(i)==s2.charAt(j)){
            take1=1+check(i-1,j-1,s1,s2);
        }else{
            take2=check(i,j-1,s1,s2);
            take3=check(i-1,j,s1,s2);
        }
        return Math.max(take1,Math.max(take2,take3));
    }
    public int minInsertions(String s) {
        int n=s.length();
        StringBuilder s2=new StringBuilder(s);
        s2.reverse();
        return n-check(n-1,n-1,s,s2.toString());
    }
}

//Memoization
class MinimumInsertionsToMakeAStringPalindromeMemoization {
    public int check(int i,int j,String s1,String s2,int[][] ans){
        if(i<0||j<0){
            return 0;
        }
        if(ans[i][j]!=-1){
            return ans[i][j];
        }
        int take1=0,take2=0,take3=0;
        if(s1.charAt(i)==s2.charAt(j)){
            take1=1+check(i-1,j-1,s1,s2,ans);
        }else{
            take2=check(i,j-1,s1,s2,ans);
            take3=check(i-1,j,s1,s2,ans);
        }
        return ans[i][j]=Math.max(take1,Math.max(take2,take3));
    }
    public int minInsertions(String s) {
        int n=s.length();
        StringBuilder s2=new StringBuilder(s);
        s2.reverse();
        int ans[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],-1);
        }
        return n-check(n-1,n-1,s,s2.toString(),ans);
    }

}

//DP

//Dp
class MinimumInsertionsToMakeAStringPalindromeDP {
    public int minInsertions(String s) {
        int n=s.length();
        StringBuilder s2=new StringBuilder(s);
        s2.reverse();
        int ans[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int take1=0,take2=0,take3=0;
                if(s.charAt(i)==s2.charAt(j)){
                    take1=1;
                    if(i-1>=0&&j-1>=0){
                        take1+=ans[i-1][j-1];
                    }
                }else{
                    if(j-1>=0){
                        take2=ans[i][j-1];
                    }
                    if(i-1>=0){
                        take3=ans[i-1][j];
                    }
                }
                ans[i][j]=Math.max(take1,Math.max(take2,take3));
            }
        }
        return n-ans[n-1][n-1];
    }
}