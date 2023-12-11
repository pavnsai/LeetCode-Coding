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



//Second approach
class Solution {
    public TreeNode build(int[] preorder,int max,int []i){
        if(preorder.length==i[0]||preorder[i[0]]>max){
            return null;
        }
        TreeNode root=new TreeNode(preorder[i[0]++]);
        root.left=build(preorder,root.val,i);
        root.right=build(preorder,max,i);
        return root;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,Integer.MAX_VALUE,new int[]{0});
    }
}