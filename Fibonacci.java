public class Fibonacci {
    public static int fibonacci(int n){
        if (n==0||n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static void main(String[] args) {
//        Fibonacci fib=new Fibonacci();
//        System.out.println(fibonacci(12));
        int n=12,a=0,b=0;
        int dp[]=new int[n+1];
        System.out.println("0");
        dp[0]=0;
        if(n>1){
            dp[1]=1;
            System.out.println("1");
        }
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
            System.out.println(dp[i]);
        }
    }
}

