public class PalindromicSubstrings {
    boolean checkPalindrome(String s){
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(checkPalindrome(s.substring(i,j+1))){
                    count++;
                }
            }
        }
        return count;
    }
}
//DP Approach
class PalindromicSubstringsDP {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean [][]dp=new boolean[n][n];
        int count=0;
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }else if(g==1){  // two length substring
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }

                if(dp[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}
//Third Approach Efficient
class PalindromicSubstringsSecond {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            int l=i,r=i;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }
            l=i;
            r=i+1;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}