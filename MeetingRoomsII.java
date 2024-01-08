import java.util.Arrays;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int [] start=new int[intervals.length];
        int [] end=new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startIndex=0,endIndex=0,count=0,ans=Integer.MIN_VALUE;
        while(startIndex<intervals.length){
            if(start[startIndex]<end[endIndex]){
                count++;
                startIndex++;
            }else{
                count--;
                endIndex++;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}
