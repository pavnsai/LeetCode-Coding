import java.net.Inet4Address;
import java.util.ArrayList;

public class Sum {
    public static void check(int i, int val[], ArrayList<Integer> al,int ans[]){
        if(i==val.length){
            int sum=0;
            for(Integer temp:al){
                sum+=temp;
            }
            if(sum%2==0){
                ans[0]=Math.max(ans[0],sum);
            }
            return;
        }
        al.add(val[i]);
        check(i+1,val,al,ans);
        al.remove(al.size()-1);
        check(i+1,val,al,ans);
        return;
    }
    public static int check2(int i, int val[],int sum){
        if(i==val.length){
            if(sum%2==0){
                return sum;
            }else {
                return Integer.MIN_VALUE;
            }
        }
        int take=check2(i+1,val,val[i]+sum);
        int notTake=check2(i+1,val,sum);
        return Math.max(take,notTake);
    }

    public static void main(String[] args) {
        int arr[]=new int[]{2,3,6,-5,10,1,1};
        int ans[]=new int[]{Integer.MIN_VALUE};
        check(0,arr,new ArrayList<>(),ans);
        System.out.println(ans[0]);
        System.out.println(check2(0,arr,0));
    }
}
