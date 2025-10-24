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
class Solution {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.val != voyage[i])return Arrays.asList(-1);
            i++;
            if(curr.left != null && voyage[i] != curr.left.val){
               result.add(curr.val);
               st.add(curr.left);
               if(curr.right != null)st.add(curr.right);
            }else{
                if(curr.right != null)st.add(curr.right);
                if(curr.left != null)st.add(curr.left);
            }
        }
    return result;
    }
}