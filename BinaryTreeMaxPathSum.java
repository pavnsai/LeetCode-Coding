public class BinaryTreeMaxPathSum {
    public int max(TreeNode root,int maxi[]){
        if(root==null){
            return 0;
        }
        int leftsum=max(root.left,maxi);
        int rightsum=max(root.right,maxi);
        maxi[0]=Math.max(maxi[0],leftsum+rightsum+root.val);
        maxi[0]=Math.max(maxi[0],root.val);
        maxi[0]=Math.max(maxi[0],Math.max(leftsum,rightsum)+root.val);
        return Math.max(root.val+Math.max(leftsum,rightsum),root.val);
    }
    public int maxPathSum(TreeNode root) {
        int maxi[]={Integer.MIN_VALUE};
        int ans=max(root,maxi);
        return maxi[0];
    }
}
