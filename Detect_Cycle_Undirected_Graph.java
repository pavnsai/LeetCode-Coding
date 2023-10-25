import java.util.ArrayList;

class Solution5 {
    // Function to detect cycle in an undirected graph.
    public boolean bfs(int i, ArrayList<ArrayList<Integer>> adj, boolean [] visited, int parent){
        ArrayList<Integer> iter=adj.get(i);
        for(Integer num:iter){
            if(num!=parent){
                if(!visited[num]){
                    visited[num]=true;
                    if(bfs(num,adj,visited,i)){
                        return true;
                    }
                }else{
                    return true;
                }
            }else{
                continue;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean [] visited=new boolean[V];
        boolean ans=false;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                visited[i]=true;
                if(bfs(i,adj,visited,-1)){
                    return true;
                }
            }
        }
        return ans;
    }
}