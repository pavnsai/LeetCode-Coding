class Solution6 {
    public int totalFruit(int[] fruits) {
        int a=-1,b=-1,ans=Integer.MIN_VALUE,acount=0,bcount=0,start=0,counter=0,n=fruits.length;
        while(counter<n){
            if(acount==0 && b!=fruits[counter]){
                a=fruits[counter];
                acount++;
                counter++;
            }
            else if(bcount==0 && a!=fruits[counter]){
                b=fruits[counter];
                bcount++;
                counter++;
            }
            else if(a==fruits[counter]){
                acount++;
                counter++;
            }
            else if(b==fruits[counter]){
                bcount++;
                counter++;
            }else{
                if(fruits[start]==a){
                    acount--;
                }else{
                    bcount--;
                }
                start++;
            }
            ans=Math.max(ans,counter-start);
        }
        return ans;
    }
}