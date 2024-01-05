public class SubTreeOfAnotherTree {
    public boolean isIdentical(TreeNode root,TreeNode subRoot){
        if(root==null&&subRoot==null){
            return true;
        }
        if(root==null||subRoot==null){
            return false;
        }
        return (root.val==subRoot.val)&&isIdentical(root.left,subRoot.left)&&isIdentical(root.right,subRoot.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null){
            return true;
        }
        if(root==null||subRoot==null){
            return false;
        }
        boolean flag=false;
        if(root.val==subRoot.val){
            flag=isIdentical(root,subRoot);
            if(flag){
                return true;
            }
        }
        return flag||isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
}
