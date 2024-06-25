import java.util.LinkedList;
import java.util.Queue;

//optimized
public class CountCompleteTreeNodes {
    public int leftHeight(TreeNode root){
        int count=0;
        while(root.left!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    public int rightHeight(TreeNode root){
        int count=0;
        while(root.right!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lt=leftHeight(root);
        int rt=rightHeight(root);
        if(lt==rt){
            return ((2<<lt)-1);
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}

 class CountCompleteTreeNodes2 {
     public int countNodes(TreeNode root) {
         if(root==null){
             return 0;
         }
         return 1+countNodes(root.left)+countNodes(root.right);
     }
 }

class CountCompleteTreeNodes3 {
    public int countNodes(TreeNode root) {
        int count=0;
        if(root==null){
            return 0;
        }
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            TreeNode temp=qu.poll();
            count++;
            if(temp.left!=null){
                qu.add(temp.left);
            }
            if(temp.right!=null){
                qu.add(temp.right);
            }
        }
        return count;
    }
}