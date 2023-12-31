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
