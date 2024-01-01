import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            if(root==null){
                return sb.append("NULL").append(",").toString();
            }
            sb.append(root.val).append(",");
            sb.append(serialize(root.left));
            sb.append(serialize(root.right));
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] preOrder = data.split(",");
            if(preOrder.length==1){
                return null;
            }
            // System.out.println(data);
            // System.out.println(preOrder.length);

            return convert(preOrder,new int[]{0});
        }
        public TreeNode convert(String[] preOrder,int arr[]){
            if(preOrder[arr[0]].equals("NULL")||arr[0]>=preOrder.length){
                arr[0]++;
                return null;
            }
            // System.out.println(preOrder[arr[0]]);
            TreeNode root=new TreeNode(Integer.valueOf(preOrder[arr[0]++]));
            root.left=convert(preOrder,arr);
            root.right=convert(preOrder,arr);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}


//Second Approach usign Level order traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class CodecQueue {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return ",";
        }
        StringBuilder st=new StringBuilder();
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        st.append(root.val).append(",");
        while(!qu.isEmpty()){
            TreeNode temp=qu.poll();
            if(temp.left!=null){
                qu.add(temp.left);
                st.append(temp.left.val).append(",");
            }else{
                st.append("#").append(",");
            }
            if(temp.right!=null){
                qu.add(temp.right);
                st.append(temp.right.val).append(",");
            }else{
                st.append("#").append(",");
            }
        }
        return st.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        String[] splitData = data.split(",");
        if(splitData.length==0){
            return null;
        }
        Queue<TreeNode> qu=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.valueOf(splitData[0]));
        int i=1;
        qu.add(root);
        while(!qu.isEmpty()){
            TreeNode temp=qu.poll();
            if(splitData[i].equals("#")){
                temp.left=null;
            }else{
                TreeNode leftNode=new TreeNode(Integer.valueOf(splitData[i]));
                qu.add(leftNode);
                temp.left=leftNode;
            }
            i++;
            // temp=qu.poll();
            if(splitData[i].equals("#")){
                temp.right=null;
            }else{
                TreeNode rightNode=new TreeNode(Integer.valueOf(splitData[i]));
                qu.add(rightNode);
                temp.right=rightNode;
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));