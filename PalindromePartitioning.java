import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public boolean isPalindrome(int a,int b,String s){
        while(a<b){
            if(s.charAt(a)!=s.charAt(b)){
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
    public void check(int idx, int n, String s, List<List<String>> ans, ArrayList<String> temp){
        if(idx==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<n;i++){
            if(isPalindrome(idx,i,s)){
                temp.add(s.substring(idx,i+1));
                check(i+1,n,s,ans,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        check(0,s.length(),s,ans,new ArrayList<String>());
        return ans;
    }
}
