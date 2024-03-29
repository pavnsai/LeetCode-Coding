public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int[] arr=new int[n+1];
        arr[1]=1;
        arr[2]=2;
        for(int i=3;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
// Without using space complexity
class ClimbingStairsNoSpace {
    public int climbStairs(int n) {
        if(n==1||n==2){
            return n;
        }
        int a=1,b=2,c=0;
        for(int i=3;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}

// Getting TLE
class ClimbingStairsTLE {
    public int climbRecursive(int n,int idx){
        if(idx==n)
            return 1;
        if(idx>n)
            return 0;
        int ans=0;
        ans+=climbRecursive(n,1+idx);
        ans+=climbRecursive(n,2+idx);
        return ans;
    }
    public int climbStairs(int n) {
        return climbRecursive(n,0);
    }
}