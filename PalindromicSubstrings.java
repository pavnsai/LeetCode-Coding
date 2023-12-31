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
//Second Approach
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