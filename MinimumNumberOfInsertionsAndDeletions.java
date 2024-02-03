import java.util.Arrays;

//TLE
 class MinimumNumberOfInsertionsAndDeletionsTLE {
    public int check(int i,int j,String s1,String s2){
        if(i<0||j<0){
            if(i<0){
                return j+1;
            }
            if(j<0){
                return i+1;
            }
        }
        int same=Integer.MAX_VALUE,insert=Integer.MAX_VALUE,delete=Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j)){
            same=check(i-1,j-1,s1,s2);
        }else{
            insert=1+check(i,j-1,s1,s2);
            delete=1+check(i-1,j,s1,s2);
        }
        return Math.min(same,Math.min(insert,delete));
    }
    public int minOperations(String s1, String s2)
    {
        // Your code goes here
        int m=s1.length(),n=s2.length();
        return check(m-1,n-1,s1,s2);
    }
}

//Memoization
class MinimumNumberOfInsertionsAndDeletionsMemoization {
    public int check(int i,int j,String s1,String s2,int[][] ans){
        if(i<0||j<0){
            if(i<0){
                return j+1;
            }
            if(j<0){
                return i+1;
            }
        }
        if(ans[i][j]!=-1){
            return ans[i][j];
        }
        int same=Integer.MAX_VALUE,insert=Integer.MAX_VALUE,delete=Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j)){
            same=check(i-1,j-1,s1,s2,ans);
        }else{
            insert=1+check(i,j-1,s1,s2,ans);
            delete=1+check(i-1,j,s1,s2,ans);
        }
        return ans[i][j]=Math.min(same,Math.min(insert,delete));
    }
    public int minOperations(String s1, String s2)
    {
        // Your code goes here
        int m=s1.length(),n=s2.length();
        int ans[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(m-1,n-1,s1,s2,ans);
    }
}

// DP
class MinimumNumberOfInsertionsAndDeletionsDP {
    public int minOperations(String s1, String s2)
    {
        // Your code goes here
        int m=s1.length(),n=s2.length();
        int ans[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int same=Integer.MAX_VALUE,insert=Integer.MAX_VALUE,delete=Integer.MAX_VALUE;
                if(s1.charAt(i)==s2.charAt(j)){
                    if(i-1>=0&&j-1>=0){
                        same=ans[i-1][j-1];
                    }else if(i-1<0){
                        same=(j-1)+1;
                    }else if(j-1<0){
                        same=(i-1)+1;
                    }
                }else{
                    if(j-1>=0){
                        insert=1+ans[i][j-1];
                    }else{
                        insert=1+(i+1);
                    }
                    if(i-1>=0){
                        delete=1+ans[i-1][j];
                    }else{
                        delete=1+(j+1);
                    }
                }
                ans[i][j]=Math.min(same,Math.min(insert,delete));
            }
        }
        return ans[m-1][n-1];
    }
}


//Memoization 2
class MinimumNumberOfInsertionsAndDeletionsMemoization2 {
    public int check(int i,int j,String s1,String s2,int[][] ans){
        if(i==0||j==0){
            if(i==0){
                return j;
            }
            if(j==0){
                return i;
            }
        }
        if(ans[i][j]!=-1){
            return ans[i][j];
        }
        int same=Integer.MAX_VALUE,insert=Integer.MAX_VALUE,delete=Integer.MAX_VALUE;
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            same=check(i-1,j-1,s1,s2,ans);
        }else{
            insert=1+check(i,j-1,s1,s2,ans);
            delete=1+check(i-1,j,s1,s2,ans);
        }
        return ans[i][j]=Math.min(same,Math.min(insert,delete));
    }
    public int minOperations(String s1, String s2) {
        // Your code goes here
        int m = s1.length(), n = s2.length();
        int ans[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(ans[i], -1);
        }
        return check(m, n, s1, s2, ans);
    }
}

// DP2
class MinimumNumberOfInsertionsAndDeletionsDP2 {
    public int minOperations(String s1, String s2) {
        // Your code goes here
        int m = s1.length(), n = s2.length();
        int ans[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            ans[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            ans[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int same = Integer.MAX_VALUE, insert = Integer.MAX_VALUE, delete = Integer.MAX_VALUE;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    same = ans[i - 1][j - 1];
                } else {
                    insert = 1 + ans[i][j - 1];
                    delete = 1 + ans[i - 1][j];
                }
                ans[i][j] = Math.min(same, Math.min(insert, delete));
            }

        }
        return ans[m][n];
    }

}

//Memoization 3
class MinimumNumberOfInsertionsAndDeletionsMemoization3 {
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
    public int minOperations(String s1, String s2)
    {
        // Your code goes here
        int m=s1.length(),n=s2.length();
        int ans[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(ans[i],-1);
        }
        int len=check(m-1,n-1,s1,s2,ans);
        return m-len+n-len;
    }
}

//DP3
class MinimumNumberOfInsertionsAndDeletionsDP3 {
    public int minOperations(String s1, String s2)
    {
        // Your code goes here
        int m=s1.length(),n=s2.length();
        int ans[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int take1=0,take2=0,take3=0;
                if(s1.charAt(i)==s2.charAt(j)){
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
        int len=ans[m-1][n-1];
        return m-len+n-len;
    }
}