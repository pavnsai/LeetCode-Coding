public class ValidateBinarySearchTree {
    public boolean isValid(TreeNode root,Integer min,Integer max){
        if(root==null){
            return true;
        }
        if((max!=null&&root.val>=max)||(min!=null&&root.val<=min)){
            return false;
        }
        return isValid(root.left,min,root.val)&&isValid(root.right,root.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);
    }
}
