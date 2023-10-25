class Solution7 {
    public boolean isPossible(String str1,String str2){
        String temp=str2;
        int n=str1.length();
        while(temp.length()<=n){
            if(temp.compareTo(str1)==0){
                return true;
            }else{
                if(str1.contains(temp)){
                    temp=temp.concat(str2);
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public String gcdOfStrings(String str1, String str2) {
        int a=0,b=0,n=str2.length();
        String ans="";
        // while(b<n){
        //     String stringToCheck=str2.substring(a,b+1);
        //     if(isPossible(str1,stringToCheck)&&isPossible(str2,stringToCheck)){
        //         ans=stringToCheck;
        //     }
        //     b++;
        // }
        int counter=gcd(str1.length(),str2.length());
        String stringToCheck=str2.substring(0,counter);
        // if(isPossible(str1,stringToCheck)&&isPossible(str2,stringToCheck)){
        //         return str2.substring(0,counter);
        //     }
        if(str1.concat(str2).equals(str2.concat(str1))){
            return str2.substring(0,counter);
        }
        return "";
    }
}