public class SelectionSort {
    int  select(int arr[], int i)
    {
        // code here such that selectionSort() sorts arr[]
        int min_idx=i;
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]<arr[min_idx]){
                min_idx=j;
            }
        }
        return min_idx;
    }
    void swap(int a, int b, int arr[]){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    void selectionSort(int arr[], int n)
    {
        //code here
        for(int i=0;i<n;i++){
            int min_idx=select(arr,i);
            swap(i,min_idx,arr);
        }
    }
}
