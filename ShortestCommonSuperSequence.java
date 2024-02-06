public class ShortestCommonSuperSequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length(),n=str2.length();
        int ans[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    ans[i][j]=1+ans[i-1][j-1];
                }else{
                    ans[i][j]=Math.max(ans[i-1][j],ans[i][j-1]);
                }
            }
        }
        String res="";
        int i=m,j=n;
        while(i>0&&j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                res+=str1.charAt(i-1);
                i=i-1;
                j=j-1;
            }else if(ans[i-1][j]>ans[i][j-1]){
                res+=str1.charAt(i-1);
                i=i-1;
            }else{
                res+=str2.charAt(j-1);
                j=j-1;
            }
        }
        while(i>0){
            res+=str1.charAt(i-1);
            i--;
        }
        while(j>0){
            res+=str2.charAt(j-1);
            j--;
        }
        StringBuilder str=new StringBuilder(res);
        return str.reverse().toString();
    }
}
