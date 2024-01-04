import java.util.HashMap;

public class MaximumWidthOfBinaryTree {
    public int dfs(TreeNode node, int depth, int index, HashMap<Integer, Integer> hm) {
        if (node == null) {
            return 0;
        }
        hm.putIfAbsent(depth, index);
        return Math.max(index - hm.get(depth) + 1,
                Math.max(dfs(node.left, depth + 1, index * 2,hm), dfs(node.right, depth + 1, index * 2 + 1,hm)));

    }

    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        return dfs(root, 1, 1,hm);
    }
}
