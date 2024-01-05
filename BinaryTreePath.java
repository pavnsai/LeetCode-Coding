import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public void build(TreeNode root, String path, List<String> li){
        if(root==null){
            return;
        }
        System.out.println(path+" "+root.val);
        if(path.length()>0){
            path+="->";
        }
        path+=root.val;
        if(root.left==null&&root.right==null){
            li.add(path);
        }
        build(root.left,path,li);
        build(root.right,path,li);
        return;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> li=new ArrayList<>();
        String path="";
        build(root,path,li);
        return li;
    }
}
