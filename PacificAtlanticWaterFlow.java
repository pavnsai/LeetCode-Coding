import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public boolean isPacific(int i,int j,boolean[][] visit,int[][] heights,int rowMax,int colMax){
        if(i==0||j==0){
            return true;
        }
        boolean flag1=false,flag2=false,flag3=false,flag4=false;
        visit[i][j]=true;
        if(i+1<rowMax&&!visit[i+1][j]&&heights[i+1][j]<=heights[i][j]){
            flag1=isPacific(i+1,j,visit,heights,rowMax,colMax);
        }
        if(i-1>=0&&!visit[i-1][j]&&heights[i-1][j]<=heights[i][j]){
            flag2=isPacific(i-1,j,visit,heights,rowMax,colMax);
        }
        if(j+1<colMax&&!visit[i][j+1]&&heights[i][j+1]<=heights[i][j]){
            flag3=isPacific(i,j+1,visit,heights,rowMax,colMax);
        }
        if(j-1>=0&&!visit[i][j-1]&&heights[i][j-1]<=heights[i][j]){
            flag4=isPacific(i,j-1,visit,heights,rowMax,colMax);
        }
        return flag1||flag2||flag3||flag4;
    }
    public boolean isAtlantic(int i,int j,boolean[][] visit,int[][] heights,int rowMax,int colMax){
        if(i==rowMax-1||j==colMax-1){
            return true;
        }
        boolean flag1=false,flag2=false,flag3=false,flag4=false;
        visit[i][j]=true;
        if(i+1<rowMax&&!visit[i+1][j]&&heights[i+1][j]<=heights[i][j]){
            flag1=isAtlantic(i+1,j,visit,heights,rowMax,colMax);
        }
        if(i-1>=0&&!visit[i-1][j]&&heights[i-1][j]<=heights[i][j]){
            flag2=isAtlantic(i-1,j,visit,heights,rowMax,colMax);
        }
        if(j+1<colMax&&!visit[i][j+1]&&heights[i][j+1]<=heights[i][j]){
            flag3=isAtlantic(i,j+1,visit,heights,rowMax,colMax);
        }
        if(j-1>=0&&!visit[i][j-1]&&heights[i][j-1]<=heights[i][j]){
            flag4=isAtlantic(i,j-1,visit,heights,rowMax,colMax);
        }
        return flag1||flag2||flag3||flag4;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[i].length;j++){
                boolean visit[][]=new boolean[heights.length][heights[i].length];
                boolean visit2[][]=new boolean[heights.length][heights[i].length];
                if(
                        isPacific(i,j,visit,heights,heights.length,heights[i].length)
                                &&
                                isAtlantic(i,j,visit2,heights,heights.length,heights[i].length)
                ){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}
