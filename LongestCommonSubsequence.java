import java.util.Arrays;

//TLE
class LongestCommonSubsequenceTLE {
    public int check(int idx1,int idx2,String text1,String text2){
        if(idx1<0||idx2<0){
            return 0;
        }
        int take1=0,take2=0,take3=0;
        if(text1.charAt(idx1)==text2.charAt(idx2)){
            take1=1+check(idx1-1,idx2-1,text1,text2);
        }else{
            take2=check(idx1-1,idx2,text1,text2);
            take3=check(idx1,idx2-1,text1,text2);
        }
        return Math.max(take1,Math.max(take2,take3));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length(),n2=text2.length();
        return check(n1-1,n2-1,text1,text2);
    }
}

//Memoization
class LongestCommonSubsequenceMemoization {
    public int check(int idx1,int idx2,String text1,String text2,int[][] ans){
        if(idx1<0||idx2<0){
            return 0;
        }
        if(ans[idx1][idx2]!=-1){
            return ans[idx1][idx2];
        }
        int take1=0,take2=0,take3=0;
        if(text1.charAt(idx1)==text2.charAt(idx2)){
            take1=1+check(idx1-1,idx2-1,text1,text2,ans);
        }else{
            take2=check(idx1-1,idx2,text1,text2,ans);
            take3=check(idx1,idx2-1,text1,text2,ans);
        }
        return ans[idx1][idx2]=Math.max(take1,Math.max(take2,take3));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length(),n2=text2.length();
        int ans[][]=new int[n1][n2];
        for(int i=0;i<n1;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(n1-1,n2-1,text1,text2,ans);
    }

}
//DP
class LongestCommonSubsequenceDP {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length(),n2=text2.length();
        int ans[][]=new int[n1][n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                int take1=0,take2=0,take3=0;
                if(text1.charAt(i)==text2.charAt(j)){
                    take1=1;
                    if(i-1>=0&&j-1>=0){
                        take1+=ans[i-1][j-1];
                    }
                }else{
                    if(i-1>=0){
                        take2=ans[i-1][j];
                    }
                    if(j-1>=0){
                        take3=ans[i][j-1];
                    }
                }
                ans[i][j]=Math.max(take1,Math.max(take2,take3));
            }
        }
        return ans[n1-1][n2-1];
    }
}


