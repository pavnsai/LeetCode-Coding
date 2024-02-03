import java.util.Arrays;

//TLE
 class DeleteOperationForTwoStringsTLE {
    public int check(int i,int j,String s1,String s2){
        if(i<0||j<0){
            if(j<0){
                return i+1;
            }
            if(i<0){
                return j+1;
            }
        }
        int same=Integer.MAX_VALUE,del1=Integer.MAX_VALUE,del2=Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j)){
            same=check(i-1,j-1,s1,s2);
        }else{
            del1=1+check(i,j-1,s1,s2);
            del2=1+check(i-1,j,s1,s2);
        }
        return Math.min(same,Math.min(del1,del2));
    }
    public int minDistance(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        return check(m-1,n-1,s1,s2);
    }
}

//Memoization
class DeleteOperationForTwoStringsMemoization {
    public int check(int i,int j,String s1,String s2,int[][] ans){
        if(i<0||j<0){
            if(j<0){
                return i+1;
            }
            if(i<0){
                return j+1;
            }
        }
        if(ans[i][j]!=-1){
            return ans[i][j];
        }
        int same=Integer.MAX_VALUE,del1=Integer.MAX_VALUE,del2=Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j)){
            same=check(i-1,j-1,s1,s2,ans);
        }else{
            del1=1+check(i,j-1,s1,s2,ans);
            del2=1+check(i-1,j,s1,s2,ans);
        }
        return ans[i][j]=Math.min(same,Math.min(del1,del2));
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
class DeleteOperationForTwoStringsDP {
    public int minDistance(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int ans[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int same=Integer.MAX_VALUE,del1=Integer.MAX_VALUE,del2=Integer.MAX_VALUE;
                if(s1.charAt(i)==s2.charAt(j)){
                    if(i-1>=0&&j-1>=0){
                        same=ans[i-1][j-1];
                    }
                    else if(j-1<0){
                        same=(i-1)+1;
                    }
                    else if(i-1<0){
                        same=(j-1)+1;
                    }
                }else{
                    if(j-1>=0){
                        del1=1+ans[i][j-1];
                    }else{
                        del1=1+(i+1);
                    }
                    if(i-1>=0){
                        del2=1+ans[i-1][j];
                    }else{
                        del2=1+(j+1);
                    }
                }
                ans[i][j]=Math.min(same,Math.min(del1,del2));
            }
        }
        return ans[m-1][n-1];
    }
}