 class Solution {
     public String mergeAlternately(String word1, String word2) {
         int length1=word1.length(),length2=word2.length(),i=0,mini=0,index=0;
         String ans="";
         if(length1>=length2){
             mini=length2;
             index=2;
         }else{
             mini=length1;
             index=1;
         }
         while(i<mini){
             // ans=
             ans=ans.concat(String.valueOf(word1.charAt(i)));
             // ans=
             ans=ans.concat(String.valueOf(word2.charAt(i)));
         // System.out.println(ans.concat(String.valueOf(word1.charAt(i))));
         // System.out.println(ans.concat(String.valueOf(word2.charAt(i))));
             i++;
         }
         System.out.println(ans);
         if(index==2){
             return ans.concat(word1.substring(mini,length1));
         }
         else{
             return ans.concat(word2.substring(mini,length2));
         }
     }
 }

 // Second Approach

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n=Math.min(word1.length(),word2.length());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(word1.length()>word2.length())
        {
            sb.append(word1.substring(n,word1.length()));
        }
        else if(word2.length()>word1.length())
        {
            sb.append(word2.substring(n,word2.length()));
        }
        else
        {
            sb.append("");
        }
        return sb.toString();
    }
}