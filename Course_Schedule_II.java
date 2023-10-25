import java.util.*;

class Solution1 {
    class Graph{
        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<Integer,ArrayList<Integer>>();
        void addEdge(int u,int v){
            if(adj.containsKey(u)){
                ArrayList<Integer> list=adj.get(u);
                list.add(v);
                adj.put(u,list);
            }else{
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(v);
                adj.put(u,list);
            }
        }
        void printEdges(){
            for(Map.Entry<Integer,ArrayList<Integer>> entry:adj.entrySet()){
                int key=entry.getKey();
                ArrayList<Integer> values=entry.getValue();
                System.out.println(key+" : "+values);
            }
        }
        void dfs(int i,boolean[] visited,Stack<Integer> st){
            visited[i]=true;
            if(adj.containsKey(i)){
                ArrayList<Integer> list=adj.get(i);
                for(Integer edge:list){
                    if(!visited[edge])
                        dfs(edge,visited,st);
                }
                st.push(i);
            }else{
                st.push(i);
            }
            return;
        }
        Stack<Integer> topological(int numCourses,boolean[] visited){
            Stack<Integer> st=new Stack<>();
            for(int i=0;i<numCourses;i++){
                if(!visited[i]){
                    dfs(i,visited,st);
                }
            }
            return st;
        }
        boolean isCycleDFS(int i,boolean[] visited, boolean[] path){
            ArrayList<Integer> temp=adj.get(i);
            if(temp!=null){
                for(Integer num:temp){
                    if(visited[num]&&path[num]){
                        return true;
                    }
                    else if(!visited[num]){
                        visited[num]=true;
                        path[num]=true;
                        if(isCycleDFS(num,visited,path)){
                            return true;
                        }
                    }
                }
            }
            path[i]=false;
            return false;
        }
        boolean isCyclic(int numCourses) {
            boolean[] visited = new boolean[numCourses];
            boolean[] path = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++){
                if(!visited[i]){
                    visited[i]=true;
                    path[i]=true;
                    if(isCycleDFS(i,visited,path)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph g=new Graph();
        boolean visited[]=new boolean[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            g.addEdge(prerequisites[i][1],prerequisites[i][0]);
        }
        g.printEdges();
        System.out.println(g.isCyclic(numCourses));
        if(g.isCyclic(numCourses)){
            return new int[0];
        }
        Stack<Integer> stack=g.topological(numCourses,visited);
        // System.out.println(stack);
        // System.out.println(stack.size());
        int[] array = new int[stack.size()];
        for (int i = 0; i <array.length; i++) {
            array[i] = stack.pop();
        }
        return array;

    }
}



// second approach



class Solution3 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(i,new ArrayList<Integer>());
        }
        int [] indegree= new int[numCourses];
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
            // if(adj.contains(prerequisites[i][1])){
            //     // ArrayList<Integer>temp=adj.get(prerequisites[i][1]);
            //     adj[prerequisites[i][1]].add(prerequisites[i][0]);
            // }else{
            //     ArrayList<Integer>temp=new ArrayList<>();
            //     temp.add(prerequisites[i][0]);
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            // }
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                qu.add(i);
            }
        }
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[numCourses];
        int i=0;
        while(!qu.isEmpty()){
            int temp=qu.poll();
            ans[i++]=temp;
            for(Integer num:adj.get(temp)){
                indegree[num]--;
                if(indegree[num]==0){
                    qu.add(num);
                }
            }
        }
        return (i==numCourses)?ans:new int[0];

    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}