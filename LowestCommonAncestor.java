import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncestor {
    Stack<TreeNode> st=new Stack<>();
    Stack<TreeNode> stp=new Stack<>();
    Stack<TreeNode> stq=new Stack<>();
    public void ancestors(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return;
        }
        st.push(root);
        if(root==p){
            stp.addAll(st);
        }
        if(root==q){
            stq.addAll(st);
        }
        ancestors(root.left,p,q);
        ancestors(root.right,p,q);
        st.pop();
        return;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestors(root,p,q);
        if(stp.size()>stq.size()){
            while(stp.size()!=stq.size()){
                stp.pop();
            }
            while(!stp.isEmpty()){
                TreeNode stpNode=stp.pop();
                TreeNode stqNode=stq.pop();
                if(stpNode==stqNode){
                    return stpNode;
                }
            }
        }else{
            while(stp.size()!=stq.size()){
                stq.pop();
            }
            while(!stp.isEmpty()){
                TreeNode stpNode=stp.pop();
                TreeNode stqNode=stq.pop();
                if(stpNode==stqNode){
                    return stpNode;
                }
            }
        }
        return null;
    }
}
//BruteForce
class LowestCommonAncestorUsingArrayList {
    public void dfs(TreeNode root, TreeNode p, ArrayList<TreeNode> li, boolean arr[]){
        if(root==null){
            return;
        }
        if(!arr[0]){
            li.add(root);
        }
        if(root==p){
            arr[0]=true;
            return;
        }
        dfs(root.left,p,li,arr);
        dfs(root.right,p,li,arr);
        if(!arr[0]){
            li.remove(li.size()-1);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> plist=new ArrayList<>();
        ArrayList<TreeNode> qlist=new ArrayList<>();
        TreeNode ans=null;
        boolean arr[]=new boolean[]{false};
        dfs(root,p,plist,arr);
        arr[0]=false;
        dfs(root,q,qlist,arr);
        for(TreeNode temp:plist){
            if(qlist.contains(temp)){
                ans=temp;
            }
        }
        return ans;
    }
}

//BruteForce
class LowestCommonAncestorUsingArrayList2 {
    public void dfs(TreeNode root, TreeNode p, TreeNode q, ArrayList<TreeNode> plist,
                    ArrayList<TreeNode> qlist, boolean arr[]){
        if(root==null){
            return;
        }
        if(!arr[0]){
            plist.add(root);
        }
        if(!arr[1]){
            qlist.add(root);
        }
        if(root==p){
            arr[0]=true;
            // return;
        }
        if(root==q){
            arr[1]=true;
            // return;
        }
        dfs(root.left,p,q,plist,qlist,arr);
        dfs(root.right,p,q,plist,qlist,arr);
        if(!arr[0]){
            plist.remove(plist.size()-1);
        }
        if(!arr[1]){
            qlist.remove(qlist.size()-1);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> plist=new ArrayList<>();
        ArrayList<TreeNode> qlist=new ArrayList<>();
        TreeNode ans=null;
        boolean arr[]=new boolean[]{false,false};
        dfs(root,p,q,plist,qlist,arr);
        for(TreeNode temp:plist){
            if(qlist.contains(temp)){
                ans=temp;
            }
        }
        return ans;
    }

}
// Second BruteForce
class LowestCommonAncestorBruteForce {
    public boolean path(TreeNode root, TreeNode p, List<TreeNode> li){
        if(root==null){
            return false;
        }
        li.add(root);
        if(root.val==p.val){
            return true;
        }
        if(path(root.left,p,li)||path(root.right,p,li)){
            return true;
        }
        li.remove(li.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> lip=new ArrayList<>();
        List<TreeNode> liq=new ArrayList<>();
        path(root,p,lip);
        path(root,q,liq);
        for(TreeNode temp:lip){
            System.out.println(temp.val+" p ");
        }
        for(TreeNode temp:liq){
            System.out.println(temp.val);
        }
        int size=Math.min(lip.size(),liq.size()),i=0;
        TreeNode ans=null;
        while(size>0){
            TreeNode node1=lip.get(i);
            TreeNode node2=liq.get(i);
            if(node1.val==node2.val){
                ans=node1;
            }
            i++;
            size--;
        }
        return ans;
    }
}

// Efficicent Approach
class LowestCommonAncestorEfficicent {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p||root==q){
            return root;
        }
        // above if loops can be combined
        TreeNode lt=lowestCommonAncestor(root.left,p,q);
        TreeNode rt=lowestCommonAncestor(root.right,p,q);
        // if(lt==null&&rt==null){
        //     return null;
        // }else // this if loop can be removed
        if(lt==null){
            return rt;
        }else if(rt==null){
            return lt;
        }else{
            return root;
        }
    }
}