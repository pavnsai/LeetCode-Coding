import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public void bfs(char[][] grid,boolean[][] vis,int a,int b,int rowMax,int colMax){
        Queue<Pair> qu=new LinkedList<Pair>();
        qu.add(new Pair(a,b));
        vis[a][b]=true;
        while(!qu.isEmpty()){
            Pair temp=qu.poll();
            if(temp.x-1>=0&&!vis[temp.x-1][temp.y]&&grid[temp.x-1][temp.y]=='1'){
                qu.add(new Pair(temp.x-1,temp.y));
                vis[temp.x-1][temp.y]=true;
            }
            if(temp.y-1>=0&&!vis[temp.x][temp.y-1]&&grid[temp.x][temp.y-1]=='1'){
                qu.add(new Pair(temp.x,temp.y-1));
                vis[temp.x][temp.y-1]=true;
            }
            if(temp.x+1<=rowMax&&!vis[temp.x+1][temp.y]&&grid[temp.x+1][temp.y]=='1'){
                qu.add(new Pair(temp.x+1,temp.y));
                vis[temp.x+1][temp.y]=true;
            }
            if(temp.y+1<=colMax&&!vis[temp.x][temp.y+1]&&grid[temp.x][temp.y+1]=='1'){
                qu.add(new Pair(temp.x,temp.y+1));
                vis[temp.x][temp.y+1]=true;
            }
        }
        return;
    }
    public int numIslands(char[][] grid) {
        int counter=0;
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(!vis[i][j]&&grid[i][j]=='1'){
                    counter++;
                    bfs(grid,vis,i,j,grid.length-1,grid[i].length-1);
                }
            }
        }
        return counter;
    }
}