package DP;

import java.util.ArrayList;

public class ArraySubSequences {
    public static void printAllSubSequences(int arr[],int i,ArrayList<Integer> al){
        if(i==arr.length){
            for(Integer num:al){
                System.out.print(num+" ");
            }
            System.out.println();
            return;
        }
        al.add(arr[i]);
        printAllSubSequences(arr,i+1,al);
        al.remove(al.size()-1);
        printAllSubSequences(arr,i+1,al);
        return;
    }
    public static void printAllSubSequencesSumK(int arr[],int i,int sum,ArrayList<Integer> al){
        if(i<0) {
            if (sum == 0) {
                for (Integer num : al) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            return;
        }
//        if(i<0||sum<0){
//            return;
//        }
        al.add(arr[i]);
        printAllSubSequencesSumK(arr,i-1,sum-arr[i],al);
        al.remove(al.size()-1);
        printAllSubSequencesSumK(arr,i-1,sum,al);
        return;
    }
    public static boolean printOneSubSequencesSumK(int arr[],int i,int sum,ArrayList<Integer> al){
        if(sum==0){
            for (Integer num : al) {
                System.out.print(num + " ");
            }
            System.out.println();
            return true;
        }
        if(i<0||sum<0){
            return false;
        }
        al.add(arr[i]);
        if(printOneSubSequencesSumK(arr,i-1,sum-arr[i],al))
        {
         return true;
        }else
        al.remove(al.size()-1);
        if(printOneSubSequencesSumK(arr,i-1,sum,al))
            return true;
        return false;
    }
    public static int countTheSubSequencesSumK(int arr[],int i,int sum,ArrayList<Integer> al){
        if(i<0){
            if(sum==0){
                for (Integer num : al) {
                    System.out.print(num + " ");
                }
                System.out.println();
                return 1;
            }
            return 0;
        }
        al.add(arr[i]);
        int l=countTheSubSequencesSumK(arr,i-1,sum-arr[i],al);
        al.remove(al.size()-1);
        int r=countTheSubSequencesSumK(arr,i-1,sum,al);
        return l+r;
    }
    public static void main(String[] args) {
        int arr[]=new int[]{3,1,2};
        ArrayList<Integer> al=new ArrayList<>();
//        printAllSubSequences(arr,0,al);
//        printAllSubSequencesSumK(arr,arr.length-1,3,al);
//        printOneSubSequencesSumK(arr,arr.length-1,3,al);
        System.out.println(countTheSubSequencesSumK(arr,arr.length-1,3,al));

    }
}
