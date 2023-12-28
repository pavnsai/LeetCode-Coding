import java.util.Queue;

public class NumberOfIslands {
    public void DFSMarking(char[][] grid, int i, int j,int n,int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j,n,m);
        DFSMarking(grid, i - 1, j,n,m);
        DFSMarking(grid, i, j + 1,n,m);
        DFSMarking(grid, i, j - 1,n,m);
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0) return 0;
        int  m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j,n,m);
                    ++count;
                }
        }
        return count;
    }


    // Approach 2

    class Solution2 {
        class Pair{
            int x;
            int y;
            Pair(int x, int y){
                this.x=x;
                this.y=y;
            }
        }
        public void bfs(char[][] grid,int a,int b,int rowMax,int colMax){
            Queue<Pair> qu=new LinkedList<Pair>();
            qu.add(new Pair(a,b));
            while(!qu.isEmpty()){
                Pair temp=qu.poll();
                if(temp.x-1>=0&&grid[temp.x-1][temp.y]=='1'){
                    qu.add(new Pair(temp.x-1,temp.y));
                    grid[temp.x-1][temp.y]='0';
                }
                if(temp.y-1>=0&&grid[temp.x][temp.y-1]=='1'){
                    qu.add(new Pair(temp.x,temp.y-1));
                    grid[temp.x][temp.y-1]='0';
                }
                if(temp.x+1<=rowMax&&grid[temp.x+1][temp.y]=='1'){
                    qu.add(new Pair(temp.x+1,temp.y));
                    grid[temp.x+1][temp.y]='0';
                }
                if(temp.y+1<=colMax&&grid[temp.x][temp.y+1]=='1'){
                    qu.add(new Pair(temp.x,temp.y+1));
                    grid[temp.x][temp.y+1]='0';
                }
            }
            return;
        }
        public int numIslands(char[][] grid) {
            int counter=0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[i].length;j++){
                    if(grid[i][j]=='1'){
                        grid[i][j]='0';
                        counter++;
                        bfs(grid,i,j,grid.length-1,grid[i].length-1);
                    }
                }
            }
            return counter;
        }
    }
}
