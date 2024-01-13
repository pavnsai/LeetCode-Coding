import java.util.ArrayList;

public class ArraySubsequencesPrintRecursion {
    static void printSubsequences(int idx, ArrayList<Integer> al,int arr[], int n){
        if(idx==n){
            for(Integer num:al){
                System.out.print(num+" ");
            }
            System.out.println("");
            return;
        }
        al.add(arr[idx]);
        printSubsequences(idx+1,al,arr,n);
        al.remove(al.size()-1);
        printSubsequences(idx+1,al,arr,n);
    }

    static void printSubsequencesofSumK(int idx, ArrayList<Integer> al,int arr[], int n,int sum,int currentSum){
        if(idx==n){
            if(currentSum==sum) {
                for (Integer num : al) {
                    System.out.print(num + " ");
                }
                System.out.println("");
            }
            return;
        }
        al.add(arr[idx]);
        printSubsequencesofSumK(idx+1,al,arr,n,sum,currentSum+arr[idx]);
        al.remove(al.size()-1);
        printSubsequencesofSumK(idx+1,al,arr,n,sum,currentSum);
    }
    static boolean flag=true;
    static void printOneSubsequencesofSumK(int idx, ArrayList<Integer> al,int arr[], int n,int sum,int currentSum){
        if(idx==n){
            if(flag&&(currentSum==sum)) {
                flag=false;
                for (Integer num : al) {
                    System.out.print(num + " ");
                }
                System.out.println("");

            }
            return;
        }
        al.add(arr[idx]);
        printOneSubsequencesofSumK(idx+1,al,arr,n,sum,currentSum+arr[idx]);
        al.remove(al.size()-1);
        printOneSubsequencesofSumK(idx+1,al,arr,n,sum,currentSum);
    }

    static boolean printOneSubsequencesofSumKOptimized(int idx, ArrayList<Integer> al,int arr[], int n,int sum,int currentSum){
        if(idx==n){
            if(currentSum==sum) {
                //condition satisfied
                for (Integer num : al) {
                    System.out.print(num + " ");
                }
                System.out.println("");
                return true;
            }
            return false;
        }
        al.add(arr[idx]);
        if(printOneSubsequencesofSumKOptimized(idx+1,al,arr,n,sum,currentSum+arr[idx]))
            return true;
        al.remove(al.size()-1);
        if(printOneSubsequencesofSumKOptimized(idx+1,al,arr,n,sum,currentSum))
            return true;
        return false;
    }
    static int printNumberOfSubsequencesofSumKOptimized(int idx, ArrayList<Integer> al,int arr[], int n,int sum,int currentSum){
        if(idx==n){
            if(currentSum==sum) {
                //condition satisfied
                for (Integer num : al) {
                    System.out.print(num + " ");
                }
                System.out.println("");
                return 1;
            }
            return 0;
        }
        al.add(arr[idx]);
        int l=printNumberOfSubsequencesofSumKOptimized(idx+1,al,arr,n,sum,currentSum+arr[idx]);

        al.remove(al.size()-1);
        int r=printNumberOfSubsequencesofSumKOptimized(idx+1,al,arr,n,sum,currentSum);

        return l+r;
    }

    public static void main(String[] args) {
        int arr[]={1,2,1};
//        printSubsequences(0,new ArrayList<Integer>(),arr,3);
//        printOneSubsequencesofSumKOptimized(0,new ArrayList<Integer>(),arr,3,2,0);
        System.out.println(printNumberOfSubsequencesofSumKOptimized(0,new ArrayList<Integer>(),arr,3,4,0));
    }
}
