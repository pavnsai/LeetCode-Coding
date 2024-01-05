import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> li=new ArrayList<>();
        if(root==null){
            return li;
        }
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        qu.add(null);
        List<Integer> level=new ArrayList<>();
        while(qu.size()>1){
            TreeNode temp=qu.poll();
            if(temp!=null){
                level.add(temp.val);
                if(temp.left!=null){
                    qu.add(temp.left);
                }
                if(temp.right!=null){
                    qu.add(temp.right);
                }
            }else{
                li.add(level);
                level=new ArrayList<>();
                qu.add(null);
            }
        }
        li.add(level);
        return li;
    }
}
