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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int bottomleft = root.val;
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(node.right != null)que.offer(node.right);
            if(node.left != null)que.offer(node.left);
            bottomleft = node.val;
        }
        return bottomleft;
    }
}