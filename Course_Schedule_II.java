import java.util.*;

class Solution {
    class Graph{
        HashMap<Integer, ArrayList<Integer>> adj=new HashMap<Integer,ArrayList<Integer>>();
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
        void dfs(int i, boolean[] visited, Stack<Integer> st){
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
        boolean isCyclicUtil(int i, boolean[] visited,
                             boolean[] recStack)
        {

            if (recStack[i])
                return true;

            if (visited[i])
                return false;

            visited[i] = true;

            recStack[i] = true;
            List<Integer> children = adj.get(i);
            if(children!=null)
            {
                for (Integer c: children)
                    if (isCyclicUtil(c, visited, recStack))
                        return true;
            }

            recStack[i] = false;

            return false;
        }
        boolean isCyclic(int numCourses) {
            // Mark all the vertices as not visited and
            // not part of recursion stack
            boolean[] visited = new boolean[numCourses];
            boolean[] recStack = new boolean[numCourses];

            // Call the recursive helper function to
            // detect cycle in different DFS trees
            for (int i = 0; i < numCourses; i++)
                if (isCyclicUtil(i, visited, recStack))
                    return true;

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