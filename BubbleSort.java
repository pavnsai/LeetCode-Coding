public class BubbleSort {
    public static void bubbleSort(int arr[], int n)
    {
        //code here
        for(int i=0;i<n;i++){
            boolean flag=false;
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(!flag){
                return;
            }
        }

    }
}
