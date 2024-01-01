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
