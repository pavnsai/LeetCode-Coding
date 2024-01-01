public class ConstructBinaryTreeFromPreOrderAndInorder {
    public TreeNode build(int[] preorder,int preStart,int[] inorder,int inStart,int inEnd){
        if(inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int idx=0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==preorder[preStart]){
                idx=i;
                break;
            }
        }
        root.left=build(preorder,preStart+1,inorder,inStart,idx-1);
        root.right=build(preorder,preStart+idx-inStart+1,inorder,idx+1,inEnd);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,inorder,0,inorder.length-1);
    }
}
