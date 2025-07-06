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
    private int maxSum = Integer.MIN_VALUE;

    private int solve(TreeNode root) {
        if (root == null) return 0;

        // Get left and right maximum path sums, ignoring negative paths
        int left = Math.max(0, solve(root.left));
        int right = Math.max(0, solve(root.right));

        // Update global maxSum (path through this node)
        maxSum = Math.max(maxSum, root.val + left + right);

        // Return max path sum going up (choose one side)
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
}
