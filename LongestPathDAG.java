import java.util.*;

public class LongestPathDAG {
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static List<Integer> topologicalSort(List<List<Edge>> graph) {
        int n = graph.size();
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, order);
            }
        }
        Collections.reverse(order);
        return order;
    }
    static void dfs(List<List<Edge>> graph, int u, boolean[] visited, List<Integer> order) {
        visited[u] = true;
        for (Edge e : graph.get(u)) {
            int v = e.to;
            if (!visited[v]) {
                dfs(graph, v, visited, order);
            }
        }
        order.add(u);
    }
    static void longestPath(List<List<Edge>> graph, int start) {
        int n = graph.size();
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[start] = 0;
        List<Integer> order = topologicalSort(graph);
        for (int u : order) {
            if (dp[u] != Integer.MIN_VALUE) {
                for (Edge e : graph.get(u)) {
                    int v = e.to;
                    int weight = e.weight;
                    if (dp[v] < dp[u] + weight) {
                        dp[v] = dp[u] + weight;
                        prev[v] = u;
                    }}}}
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        List<Integer> longestPath = new ArrayList<>();
        int current = maxIndex;
        while (current != start) {
            longestPath.add(current);
            current = prev[current];
        }
        longestPath.add(start);
        Collections.reverse(longestPath);
        System.out.println("Longest path from " + start + ": " + longestPath);
        System.out.println("Length of longest path: " + (dp[maxIndex]+1));
    }
    public static void main(String[] args) {
        int n = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Edge(1, 5));
        graph.get(0).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 6));
        graph.get(1).add(new Edge(2, 2));
        graph.get(2).add(new Edge(4, 4));
        graph.get(2).add(new Edge(5, 2));
        graph.get(3).add(new Edge(4, 6));
        graph.get(3).add(new Edge(5, 7));
        int start = 0;
        longestPath(graph, start);
    }
}
