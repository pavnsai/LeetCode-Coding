import java.util.ArrayList;

public class RatInAMazeI {
    public static void check(int a,int b,int rowMax,int[][] m,ArrayList<String> ans,
                             boolean[][]visited,String temp){
        if(a==rowMax-1&&b==rowMax-1){
            ans.add(temp);
            return;
        }
        visited[a][b]=true;
        // added sequence in alphabetical order
        if(a+1<rowMax&&m[a+1][b]==1&&!visited[a+1][b]){
            check(a+1,b,rowMax,m,ans,visited,temp+"D");
        }
        if(b-1>=0&&m[a][b-1]==1&&!visited[a][b-1]){
            check(a,b-1,rowMax,m,ans,visited,temp+"L");
        }
        if(b+1<rowMax&&m[a][b+1]==1&&!visited[a][b+1]){
            check(a,b+1,rowMax,m,ans,visited,temp+"R");
        }
        if(a-1>=0&&m[a-1][b]==1&&!visited[a-1][b]){
            check(a-1,b,rowMax,m,ans,visited,temp+"U");
        }

        visited[a][b]=false;
        return;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans=new ArrayList<>();
        if(m[0][0]==0||m[n-1][n-1]==0){
            return ans;
        }
        boolean[][] visited=new boolean[n][n];
        check(0,0,n,m,ans,visited,"");
        return ans;
    }
}
