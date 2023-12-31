public class InvertTree {
    public void invert(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        invert(root.left);
        invert(root.right);
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        return;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        invert(root);
        return root;
    }
}
