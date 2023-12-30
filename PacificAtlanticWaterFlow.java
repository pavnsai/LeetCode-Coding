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
// Second Approach
class Solution20 {
    public void bfs(int i,int j,boolean[][] visit,int[][] heights,int rowMax,int colMax,int arr[]){
        if(i==0||j==0){
            arr[0]=1;
            // return ;
        }
        if(i==rowMax-1||j==colMax-1){
            arr[1]=1;
            // return;
        }
        visit[i][j]=true;
        if(i+1<rowMax&&!visit[i+1][j]&&heights[i+1][j]<=heights[i][j]){
            bfs(i+1,j,visit,heights,rowMax,colMax,arr);
        }
        if(i-1>=0&&!visit[i-1][j]&&heights[i-1][j]<=heights[i][j]){
            bfs(i-1,j,visit,heights,rowMax,colMax,arr);
        }
        if(j+1<colMax&&!visit[i][j+1]&&heights[i][j+1]<=heights[i][j]){
            bfs(i,j+1,visit,heights,rowMax,colMax,arr);
        }
        if(j-1>=0&&!visit[i][j-1]&&heights[i][j-1]<=heights[i][j]){
            bfs(i,j-1,visit,heights,rowMax,colMax,arr);
        }
        return;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[i].length;j++){
                boolean visit[][]=new boolean[heights.length][heights[i].length];
                int arr[]=new int[2];
                bfs(i,j,visit,heights,heights.length,heights[i].length,arr);
                if(arr[0]==1&&arr[1]==1){
                    // System.out.println(i+" "+j);
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}

// Efficient Approach check logic sign different

class SolutionEfficient {
    public void bfs(int i,int j,boolean[][] visit,int[][] heights,int rowMax,int colMax){
        visit[i][j]=true;
        if(i+1<rowMax&&!visit[i+1][j]&&heights[i+1][j]>=heights[i][j]){
            bfs(i+1,j,visit,heights,rowMax,colMax);
        }
        if(i-1>=0&&!visit[i-1][j]&&heights[i-1][j]>=heights[i][j]){
            bfs(i-1,j,visit,heights,rowMax,colMax);
        }
        if(j+1<colMax&&!visit[i][j+1]&&heights[i][j+1]>=heights[i][j]){
            bfs(i,j+1,visit,heights,rowMax,colMax);
        }
        if(j-1>=0&&!visit[i][j-1]&&heights[i][j-1]>=heights[i][j]){
            bfs(i,j-1,visit,heights,rowMax,colMax);
        }
        return;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];
        for(int row = 0; row < m; row++){
            bfs(row, 0, pacificVisited,heights,m,n);
            bfs(row, n-1, atlanticVisited,heights,m,n);
        }
        for(int col = 0; col < heights[0].length; col++){
            bfs(0, col, pacificVisited,heights,m,n);
            bfs(m-1,col, atlanticVisited,heights,m,n);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacificVisited[i][j] && atlanticVisited[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}