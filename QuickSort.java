public class QuickSort {
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        if(low<high){
            int idx = partition(arr, low, high);
            quickSort(arr, low, idx - 1);
            quickSort(arr, idx + 1, high);
        }
    }
    static void swap(int arr[],int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
        int pivot=arr[low],k=low+1;
        for(int i=low+1;i<=high;i++){
            if(arr[i]<pivot){
                swap(arr,i,k);
                k++;
            }
        }
        swap(arr,k-1,low);
        return k-1;
    }
}
