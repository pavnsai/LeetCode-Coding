import java.util.ArrayList;

public class Course_Schedule {
    public boolean dfs(boolean[]visited, ArrayList<ArrayList<Integer>> adj, int i, boolean[] path){
        ArrayList<Integer> temp=adj.get(i);
        for(Integer num:temp){
            if(path[num]&&visited[num]){
                return true;
            }
            else if(!visited[num]){
                visited[num]=true;
                path[num]=true;
                if(dfs(visited,adj,num,path)){
                    return true;
                }
            }
        }
        path[i]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>mp=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            mp.add(i,new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            mp.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean visited[]=new boolean[numCourses];
        boolean path[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                visited[i]=true;
                path[i]=true;
                if(dfs(visited,mp,i,path)){
                    return false;
                }
            }
        }
        return true;

    }
}
