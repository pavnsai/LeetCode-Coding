import java.util.ArrayList;

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
                       boolean[] path, int parent){
        ArrayList<Integer> temp=adj.get(i);
        for(Integer num:temp){
            if(path[num]&&visited[num]){
                return true;
            }else if(!visited[num]){
                visited[num]=true;
                path[num]=true;
                if(dfs(num,adj,visited,path,i)){
                    return true;
                }
            }
        }
        path[i]=false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited=new boolean[V],path=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                visited[i]=true;
                path[i]=true;
                if(dfs(i,adj,visited,path,-1)){
                    return true;
                }
            }
        }
        return false;
    }
}