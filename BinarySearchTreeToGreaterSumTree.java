public class BinarySearchTreeToGreaterSumTree {
    public void check(TreeNode root, int arr[]){
        if(root==null){
            return;
        }
        check(root.right,arr);
        arr[0]+=root.val;
        root.val=arr[0];
        check(root.left,arr);
    }
    public TreeNode bstToGst(TreeNode root) {
        int arr[]=new int[]{0};
        check(root,arr);
        return root;
    }
}
