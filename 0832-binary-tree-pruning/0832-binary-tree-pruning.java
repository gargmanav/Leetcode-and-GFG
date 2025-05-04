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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;

        // Recursively prune left and right subtrees
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // If current node is 0 and both children are pruned (null), prune this node too
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }

        return root;
    }
}