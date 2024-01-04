//Also Efficient
public class DiameterOfBinaryTree {
        class TreeInfo{
            int diam;
            int height;
            TreeInfo(int diam,int height){
                this.diam=diam;
                this.height=height;
            }
        }
        public TreeInfo diameter(TreeNode root){
            if(root==null){
                return new TreeInfo(0,0);
            }
            TreeInfo lh=diameter(root.left);
            TreeInfo rh=diameter(root.right);
            int nodeHeight=1+Math.max(lh.height,rh.height);
            int leftdiam=lh.diam;
            int rightdiam=rh.diam;
            int nodeDiam=Math.max(leftdiam,Math.max(rightdiam,lh.height+rh.height));
            return new TreeInfo(nodeDiam,nodeHeight);
        }
        public int diameterOfBinaryTree(TreeNode root) {
            if(root==null){
                return 0;
            }
            TreeInfo ans=diameter(root);
            return ans.diam;
        }
}

//Efficicent
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
class SolutionEfficientUsingHeight {
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=1+height(root.left);
        int right=1+height(root.right);
        return Math.max(left,right);
    }
    public int diameter(TreeNode root,int[] arr){
        if(root==null){
            return 0;
        }
        int lh=diameter(root.left,arr);
        int rh=diameter(root.right,arr);
        arr[0]=Math.max(arr[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int arr[]={Integer.MIN_VALUE};
        int ans=diameter(root,arr);
        return arr[0];
    }
}
//Brute Force max of leftheight+rightheight
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
class SolutionHeightBruteForce {
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=1+height(root.left);
        int right=1+height(root.right);
        return Math.max(left,right);
    }
    public void diameter(TreeNode root,int[] arr){
        if(root==null){
            return ;
        }
        diameter(root.left,arr);
        diameter(root.right,arr);
        arr[0]=Math.max(arr[0],height(root.left)+height(root.right));
        return;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int arr[]={Integer.MIN_VALUE};
        diameter(root,arr);
        return arr[0];
    }
}

// Another BruteForce

class SolutionAnotherBruteForce {
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=1+height(root.left);
        int right=1+height(root.right);
        return Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDiam=diameterOfBinaryTree(root.left);
        int rightDiam=diameterOfBinaryTree(root.right);
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return Math.max(leftDiam,Math.max(leftHeight+rightHeight,rightDiam));
    }
}