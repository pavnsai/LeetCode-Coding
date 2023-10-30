
// * Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution11 {
    class TreeInfo{
        int val;
        TreeInfo(int val){
            this.val=val;
        }
    }
    int realAns=0;
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 0;
        }
        int leftAnsReturned=dfs(root.left);
        int rightAnsReturned=dfs(root.right);
        int rootAns=0,leftAns=0,rightAns=0;
        if(root.right!=null&&root.val==root.right.val){
            leftAns=rightAnsReturned+1;
        }
        if(root.left!=null&&root.val==root.left.val){
            rightAns=leftAnsReturned+1;
        }
        realAns=Math.max(realAns,leftAns+rightAns);
        return Math.max(leftAns,rightAns);
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
        int ans=dfs(root);
        return realAns;
    }
}


// Second Approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solutionlon {
    class TreeInfo{
        int val;
        TreeInfo(int val){
            this.val=val;
        }
    }
    int realAns=0;
    public TreeInfo dfs(TreeNode root){
        if(root==null){
            return new TreeInfo(0);
        }
        if(root.left==null&&root.right==null){
            return new TreeInfo(0);
        }
        TreeInfo leftAnsReturned=dfs(root.left);
        TreeInfo rightAnsReturned=dfs(root.right);
        int rootAns=0,leftAns=0,rightAns=0;
        if(root.right!=null&&root.val==root.right.val){
            leftAns=rightAnsReturned.val+1;
        }
        if(root.left!=null&&root.val==root.left.val){
            rightAns=leftAnsReturned.val+1;
        }
        realAns=Math.max(realAns,leftAns+rightAns);
        return new TreeInfo(Math.max(leftAns,rightAns));
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
        TreeInfo ans=dfs(root);
        return realAns;
    }
}