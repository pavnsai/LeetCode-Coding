public class BSTFromPreorder {
    public TreeNode build(int[] preorder,int preStart,int preEnd){
        if(preStart>preEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int index=preEnd+1;
        for(int i=preStart+1;i<=preEnd;i++){
            if(preorder[i]>preorder[preStart]){
                index=i;
                break;
            }
        }
        root.left=build(preorder,preStart+1,index-1);
        root.right=build(preorder,index,preEnd);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,0,preorder.length-1);
    }
}
