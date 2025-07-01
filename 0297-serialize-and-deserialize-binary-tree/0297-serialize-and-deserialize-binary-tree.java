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
    public void serialize(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("null,");
            return; // <- missing return earlier
        }
        str.append(root.val + ",");
        serialize(root.left, str);
        serialize(root.right, str);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize(root, str);
        return str.toString();
    }
    private int idx = 0;
    public TreeNode deserialize(String[] arr){
        if(idx >= arr.length || arr[idx].equals("null")){
            idx++;
            return null;
        }
        TreeNode curr = new TreeNode(Integer.parseInt(arr[idx++]));
        curr.left = deserialize(arr);
        curr.right = deserialize(arr);
        return curr; // <- missing return earlier
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        idx = 0; // reset for each call
        return deserialize(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));