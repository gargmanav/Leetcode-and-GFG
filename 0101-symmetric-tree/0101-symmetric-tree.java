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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode[]> que = new LinkedList<>();
        if(root == null)return false;
        que.add(new TreeNode[]{root.left,root.right});
        while(!que.isEmpty()){
            TreeNode[] temp = que.poll();
            TreeNode root1 = temp[0];
            TreeNode root2 = temp[1];
            
            if(root1 == null && root2 == null)continue;
            if(root1 == null || root2 == null)return false;
            if(root1.val != root2.val)return false;
             
            que.add(new TreeNode[]{root1.left,root2.right});
            que.add(new TreeNode[]{root1.right,root2.left});
        }
        return true;
    }
}