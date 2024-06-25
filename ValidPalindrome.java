public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        s=s.toLowerCase();
        while(l<=r){
            int lAscii=s.charAt(l)-'a';
            int rAscii=s.charAt(r)-'a';
            if(!((lAscii>=0 && lAscii<26)||(lAscii>=-49 && lAscii<=-40))){
                l++;
                continue;
            }
            if(!((rAscii>=0 && rAscii<26)||(rAscii>=-49 && rAscii<=-40))){
                r--;
                continue;
            }
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }else{
                l++;
                r--;
            }
        }
        return true;
    }
}
