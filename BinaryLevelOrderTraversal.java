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

// Second approach using recursion
class BinaryLevelOrderTraversalrecursion {
    List<Integer> levellist=new ArrayList<>();
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=1+height(root.left);
        int rh=1+height(root.right);
        return Math.max(lh,rh);
    }
    public void level(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(level==1){
            levellist.add(root.val);
        }else if(level>1){
            level(root.left,level-1);
            level(root.right,level-1);
        }
        return;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> li=new ArrayList<>();
        if(root==null){
            return li;
        }
        int hght=height(root);
        for(int i=1;i<=hght;i++){
            level(root,i);
            li.add(levellist);
            levellist=new ArrayList<>();
        }
        return li;
    }
}