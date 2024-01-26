class UniquePathsIITLE {
    public int dfs(int a,int b,int[][] obstacleGrid){
        if(a==0&&b==0&&obstacleGrid[a][b]==0){
            return 1;
        }
        if(a<0||b<0||obstacleGrid[a][b]==1){
            return 0;
        }
        int up=dfs(a-1,b,obstacleGrid);
        int left=dfs(a,b-1,obstacleGrid);
        return up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return dfs(obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid);
    }
}
