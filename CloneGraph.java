import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public void dfs(Node node,Node newStart,Node[] visited){
        visited[newStart.val]=newStart;
        for(Node neighbor:node.neighbors){
            if(visited[neighbor.val]==null){
                Node temp=new Node(neighbor.val);
                newStart.neighbors.add(temp);
                dfs(neighbor,temp,visited);
            }else{
                newStart.neighbors.add(visited[neighbor.val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Node newStart=new Node(node.val);
        Node[] visited=new Node[101];
        Arrays.fill(visited , null);
        dfs(node,newStart,visited);
        return newStart;
    }
}
