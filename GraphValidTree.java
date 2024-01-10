import java.util.ArrayList;

public class GraphValidTree {
    public boolean dfs(int i,ArrayList<ArrayList<Integer>> adj, boolean[] visited,int parent,int[] arr){
        ArrayList<Integer> iter=adj.get(i);
        for(Integer num:iter){
            if(num!=parent){
                if(!visited[num]){
                    visited[num]=true;
                    arr[0]++;
                    if(dfs(num,adj,visited,i,arr)){
                        return true;
                    }
                }else{
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<n;i++){
            adj.add(i,new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int arr[]={1};
        boolean [] visited=new boolean[n];
        if(dfs(0,adj,visited,-1,arr)){
            return false;
        }
        return arr[0]==n;
    }
}
