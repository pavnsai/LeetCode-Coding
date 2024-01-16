import java.util.Arrays;

public class FibonacciNumber {
    public int fib(int n) {
        if(n==0||n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}
//Optimized using memoization technique
class FibonacciNumberOptimized {
    public int fibonacci(int n,int[] arr){
        if(n==0||n==1){
            return arr[n];
        }
        if(arr[n-1]==-1)
            arr[n-1]=fibonacci(n-1,arr);
        if(arr[n-1]==-1)
            arr[n-2]=fibonacci(n-2,arr);
        return arr[n-1]+arr[n-2];

    }
    public int fib(int n) {
        if(n==0||n==1){
            return n;
        }
        int arr[]=new int[n];
        Arrays.fill(arr,-1);
        arr[0]=0;
        arr[1]=1;
        return fibonacci(n,arr);
    }
}
