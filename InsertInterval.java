import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> ans=new ArrayList<>();
            int start,end;
            for(int i=0;i<intervals.length;i++){
                if(intervals[i][1]<newInterval[0]){
                    ans.add(new int[]{intervals[i][0],intervals[i][1]});
                }
                else if(intervals[i][0]>newInterval[1]){
                    ans.add(newInterval);
                    newInterval=intervals[i];
                }
                else{
                    newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
                    newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
                }
            }
            ans.add(newInterval);
            return ans.toArray(new int[ans.size()][]);
        }
}

//Logic is finding start and end index of newinterval overlappings and add min,max accordingly
//and added if clauses as well

class CompleteBruteForce {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start=-1,end=-1;
        List<int[]> li=new ArrayList<>();
        if(intervals.length==0){
            return new int[][]{newInterval};
        }
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]<newInterval[0]){

            }
            else if(intervals[i][0]>newInterval[1]){

            }
            else{
                if(start==-1){
                    start=i;
                }
                end=i;
            }
        }
//        System.out.println(start+" "+end);
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        if(start==-1){
            boolean flag=false,flag2=false;;
            if(intervals[0][0]>newInterval[1]){
                li.add(newInterval);
                flag2=true;
            }
            for(int i=0;i<intervals.length-1;i++){
                if(intervals[i][1]<newInterval[0]&&newInterval[1]<intervals[i+1][0]){
                    flag=true;
                    li.add(intervals[i]);
                    li.add(newInterval);
                }else{
                    li.add(intervals[i]);
                }
            }
            if(!flag){
                if(intervals[intervals.length-1][1]<newInterval[0]){
                    li.add(intervals[intervals.length-1]);
                    li.add(newInterval);
                }
                else{
                    if(!flag2)
                        li.add(newInterval);
                    li.add(intervals[intervals.length-1]);
                }
            }else{
                li.add(intervals[intervals.length-1]);
            }
            return li.toArray(new int[li.size()][]);
        }
        for(int i=start;i<=end;i++){
            min=Math.min(min,Math.min(intervals[i][0],newInterval[0]));
            max=Math.max(max,Math.max(intervals[i][1],newInterval[1]));
        }
//        System.out.println(min+" "+max);
        for(int i=0;i<intervals.length;i++){
            if(start<=i&&i<=end){
                if(i==end){
                    li.add(new int[]{min,max});
                }
            }else{
                li.add(intervals[i]);
            }
        }
        return li.toArray(new int[li.size()][]);
    }
}