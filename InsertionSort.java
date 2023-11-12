public class InsertionSort {
    static void insert(int arr[],int i)
    {
        // Your code here
        int key=arr[i],j=i-1;
        while(j>=0&&arr[j]>key){
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=key;
    }
    void swap(int a, int b, int arr[]){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    //Function to sort the array using insertion sort algorithm.
    public void insertionSort(int arr[], int n)
    {
        //code here
        for(int i=0;i<n;i++){
            insert(arr,i);
        }
    }
}
