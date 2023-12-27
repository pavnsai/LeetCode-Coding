public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            boolean freq[]=new boolean[256];
            for(int j=i;j<s.length();j++){
                if(freq[s.charAt(j)]){
                    break;
                }
                freq[s.charAt(j)]=true;
                ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}
