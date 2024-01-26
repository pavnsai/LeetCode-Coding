import java.util.Arrays;
import java.util.List;
//can be done with keeping first element in function also
class TriangleTLE {
     public int check(int idx,int rowIdx,int n,List<List<Integer>> triangle){
         if(idx+1>=n){
             return 0;
         }
         int curr1=triangle.get(idx+1).get(rowIdx)+check(idx+1,rowIdx,n,triangle);
         int curr2=triangle.get(idx+1).get(rowIdx+1)+check(idx+1,rowIdx+1,n,triangle);
         return Math.min(curr1,curr2);
     }
     public int minimumTotal(List<List<Integer>> triangle) {
         return check(0,0,triangle.size(),triangle)+triangle.get(0).get(0);
     }
}

class TriangleMemoization{
    public int check(int idx,int colIdx,int n,List<List<Integer>> triangle,int ans[][]){
        if(idx+1>=n){
            return 0;
        }
        if(ans[idx][colIdx]!=-1){
            return ans[idx][colIdx];
        }
        int curr1=triangle.get(idx+1).get(colIdx)+check(idx+1,colIdx,n,triangle,ans);
        int curr2=triangle.get(idx+1).get(colIdx+1)+check(idx+1,colIdx+1,n,triangle,ans);
        ans[idx][colIdx]=Math.min(curr1,curr2);
        return Math.min(curr1,curr2);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans[][]=new int[triangle.size()][triangle.size()];
        for(int i=0;i<ans.length;i++){
            Arrays.fill(ans[i],-1);
        }
        return check(0,0,triangle.size(),triangle,ans)+triangle.get(0).get(0);
    }
}

class TriangleDP{
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int ans[][]=new int[n][n];
        // for(int i=0;i<n;i++){
        //     ans[n-1][i]=triangle.get(n-1).get(i);
        // }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                ans[i][j]=Math.min(triangle.get(i+1).get(j)+ans[i+1][j],
                        triangle.get(i+1).get(j+1)+ans[i+1][j+1]);
            }
        }
        return ans[0][0]+triangle.get(0).get(0);
    }

}