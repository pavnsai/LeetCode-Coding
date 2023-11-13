public class RadixSort {
    static int getMax(int arr[], int n){
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(maxi<arr[i]){
                maxi=arr[i];
            }
        }
        return maxi;
    }
    static void radixSort(int arr[], int n)
    {
        // code here
        int maxi=getMax(arr,n);
        // System.out.println(maxi);
        for(int place=1;maxi/place>0;place*=10){
            int count[]=new int[10];
            for(int i=0;i<n;i++){
                count[(arr[i]/place)%10]++;
            }
            for(int i=1;i<10;i++){
                count[i]+=count[i-1];
            }
            int out[]=new int[n];
            for(int i=n-1;i>=0;i--){
                out[count[(arr[i]/place)%10]-1]=arr[i];
                count[(arr[i]/place)%10]--;
            }
            for(int i=0;i<n;i++){
                arr[i]=out[i];
            }
        }
    }
}
