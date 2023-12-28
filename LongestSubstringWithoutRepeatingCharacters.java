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

    // Second Approach
    public int lengthOfLongestSubstring2(String s) {
        int ans=0,l=0,r=0,n=s.length();
        int freq[]=new int[256];
        while(r<n){
            freq[s.charAt(r)]++;
            while(freq[s.charAt(r)]>1){
                freq[s.charAt(l)]--;
                l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}
